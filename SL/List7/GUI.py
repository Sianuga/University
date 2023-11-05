
import os
import tkinter as tk
from datetime import datetime
from tkinter import filedialog

import guiLogic

class LogViewer:

    def __init__(self, master):

        self.master = master

        self.logs = []
        self.currentLogIndex = None

        fromLabel = tk.Label(self.master, text="From:")
        fromLabel.pack()

        self.fromEntry = tk.Entry(self.master, width=20)
        self.fromEntry.pack()

        toLabel = tk.Label(self.master, text="To:")
        toLabel.pack()

        self.toEntry = tk.Entry(self.master, width=20)
        self.toEntry.pack()

        self.logListbox = tk.Listbox(self.master, width=50)
        self.logListbox.pack()
        self.logListbox.bind('<<ListboxSelect>>', self.onLogSelected)

        self.logDetailsFrame = tk.Frame(self.master)
        self.logDetailsFrame.pack()

        self.labels = []
        self.entryWidgets = []

        self.loadButton = tk.Button(self.master, text="Load Logs", command=self.loadLogs)
        self.loadButton.pack()

        self.applyFilterButton = tk.Button(self.master, text="Apply Filter", command=self.applyFilter)
        self.applyFilterButton.pack()

        self.previousButton = tk.Button(self.master, text="Previous", state=tk.DISABLED, command=self.showPreviousLog)
        self.previousButton.pack(side=tk.LEFT, padx=10, pady=10)

        self.nextButton = tk.Button(self.master, text="Next", state=tk.DISABLED, command=self.showNextLog)
        self.nextButton.pack(side=tk.RIGHT, padx=10, pady=10)

        self.master.title("LOG VIEWER")

    def loadLogs(self, givenLogs=False):
        if not givenLogs:
            filePath = filedialog.askopenfilename(initialdir=os.getcwd(), title="Select Log File")
            fileName = os.path.basename(filePath)
            self.master.title("LOG VIEWER: " + fileName)
            self.logs = guiLogic.processLogFile(filePath)
        
        if self.logs is not None:

            self.logListbox.delete(0, tk.END)
            for log in self.logs:
                truncatedLog = log['raw'][:30] + "..." if len(log['raw']) > 30 else log['raw']
                self.logListbox.insert(tk.END, truncatedLog)

            if self.logs:
                self.currentLogIndex = 0
                self.updateLogsNavigation()

    def updateLogsNavigation(self):
        self.showLogDetails(self.currentLogIndex)
        self.logListbox.selection_clear(0, tk.END)
        self.logListbox.selection_set(self.currentLogIndex)
        self.updateNavigationButtonsState()
        


    def showLogDetails(self, logIndex):
        if self.labels:
            for label in self.labels:
                label.destroy()
            self.labels.clear()

        if self.entryWidgets:
            for entryWidget in self.entryWidgets:
                entryWidget.destroy()
            self.entryWidgets.clear()

        log = self.logs[logIndex]

        row = 0
        for key, value in log.items():
            if key == 'raw':
                continue
            label = tk.Label(self.logDetailsFrame, text=key + ":")
            label.grid(row=row, column=0, sticky=tk.E)
            self.labels.append(label)

            entry = tk.Entry(self.logDetailsFrame, width=70)
            entry.insert(tk.END, value)
            entry.configure(state='readonly')
            entry.grid(row=row, column=1, sticky=tk.W)
            self.entryWidgets.append(entry)

            row += 1

    def showPreviousLog(self):
        if self.currentLogIndex > 0:
            self.currentLogIndex -= 1
            self.updateLogsNavigation()
            self.logListbox.see(self.currentLogIndex)


    def showNextLog(self):
        if self.currentLogIndex < len(self.logs) - 1:
            self.currentLogIndex += 1
            self.updateLogsNavigation()
            self.logListbox.see(self.currentLogIndex)


    def updateNavigationButtonsState(self):
        if self.currentLogIndex == 0:
            self.previousButton.config(state=tk.DISABLED)
        else:
            self.previousButton.config(state=tk.NORMAL)

        if self.currentLogIndex == len(self.logs) - 1:
            self.nextButton.config(state=tk.DISABLED)
        else:
            self.nextButton.config(state=tk.NORMAL)

    def onLogSelected(self, event):
        selectedIndex = self.logListbox.curselection()
        if selectedIndex:
            self.currentLogIndex = selectedIndex[0]
        self.updateLogsNavigation()

    def applyFilter(self):
        filteredLogs = []
        fromTimestamp = self.fromEntry.get()
        toTimestamp = self.toEntry.get()

        fromDate = datetime.strptime(fromTimestamp, '%Y-%m-%d').date()
        toDate = datetime.strptime(toTimestamp, '%Y-%m-%d').date()

        for log in self.logs:
            logDate = log['timestamp'].date()
            if fromDate <= logDate <= toDate:
                filteredLogs.append(log)

        self.logs = filteredLogs
        self.loadLogs(True)
        self.showLogDetails(self.currentLogIndex)
        self.updateNavigationButtonsState()


