import subprocess
import sys
import os
import json

def returnReadable(dirPath):
    executables = []
    if(os.path.isdir(dirPath)):
         for file in os.listdir(dirPath):
            filePath = os.path.join(dirPath, file)
            if os.access(filePath, os.R_OK):
                executables.append(file)
    
    return executables

def sumInfo(filesResults):
    sumOfChars = 0
    sumOfWords = 0
    numberOfFiles = 0
    sumOfLines = 0
    mostCommonChar = ""
    mostCommonWord = ""
    mostCommonWordCount = 0
    mostCommonCharCount = 0

    for file in filesResults:
        sumOfChars += file["numberOfChars"]
        sumOfWords += file["numberOfWords"]
        sumOfLines += file["numberOfLines"]
        numberOfFiles += 1

        if file["mostCommonChar"][1] > mostCommonCharCount:
            mostCommonChar = file["mostCommonChar"][0]
            mostCommonCharCount = file["mostCommonChar"][1]

        if file["mostCommonWord"][1] > mostCommonWordCount:
            mostCommonWord = file["mostCommonWord"][0]
            mostCommonWordCount = file["mostCommonWord"][1]

    print(json.dumps({"numberOfChars":sumOfChars,"numberOfWords":sumOfWords,"numberOfLines":sumOfLines,"mostCommonChar":(mostCommonChar,mostCommonCharCount),"mostCommonWord":(mostCommonWord,mostCommonWordCount),"numberOfFiles":numberOfFiles}))



def filesInfoFromDir(dirPath):

    if not os.path.isdir(dirPath):
        print("Incorrect dir path!")
    else:

        filesResults = []

        files = returnReadable(dirPath)
        for file in files:
            if os.path.isdir(os.path.join(dirPath,file)):
                continue
            else:
                filePath = os.path.join(dirPath, file)
                fileOutput = subprocess.check_output(["python","Ex3.py",filePath]).decode()
                outputFile, fileDict = fileOutput.split(None,1)
                result = json.loads(fileDict.strip())
                filesResults.append(result)

        sumInfo(filesResults)
                

if __name__ == "__main__":
    params = sys.argv
    if len(params) == 2 and os.path.isdir(params[1]):
        filesInfoFromDir(params[1])
    else:
        print("Incorrect params!")