import sys
import subprocess
import os
import time
import csv
import shutil







def createBackup(path):
 
    if os.path.isdir(path):
        timestamp = time.strftime("%Y%m%d%H%M%S")
        dirname = os.path.basename(os.path.normpath(path))
        filename = timestamp + "-" + dirname

        envVar = os.getenv("BACKUPS_DIR")

        if envVar is not None:
            backupDir = envVar.strip()
        else:
            backupDir = os.path.join(os.path.expanduser("~"), ".backups")


 
        if not os.path.isdir(backupDir):
            os.mkdir(backupDir)

        backupPath = os.path.join(backupDir, filename)
        shutil.make_archive(backupPath, "zip", path)
        
        backupHistoryPath = os.path.join(backupDir, "backupHistory.csv")               

        if os.path.isfile(backupHistoryPath):
            with open(backupHistoryPath, "a", newline="") as f:
                writer = csv.writer(f)
                writer.writerow([timestamp, path, filename])
        else:
            with open(backupHistoryPath, "w", newline="") as f:
                writer = csv.writer(f)
                writer.writerow(["timestamp", "path", "filename"])
                writer.writerow([timestamp, path, filename])



if __name__ == "__main__":
    params = sys.argv
    if len(params) == 2 and os.path.isdir(params[1]):
        createBackup(params[1])
    else:
        print("Usage: python backup.py <path>")