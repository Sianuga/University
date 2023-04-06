import os 
import sys

def getExecutable(dirPath):
    executables = []
    if(os.path.isdir(dirPath)):
         for file in os.listdir(dirPath):
            filePath = os.path.join(dirPath, file)
            if os.access(filePath, os.X_OK):
                executables.append(file)
    
    return executables

def pathInfo():
    envVar = os.environ.get("PATH")
    params = sys.argv
    splitEnvVar = envVar.split(";")
    if len(params) == 2 and params[1]=="-f":
        for path in splitEnvVar:
            print(path)
    elif len(params) == 2 and params[1]=="-d":
        for path in splitEnvVar:
            print(path)
            for file in getExecutable(path):
                print(file)
    else:
        print("Incorrect params (possible: -f, -d)")

if __name__ == "__main__":
    params = sys.argv
    if len(params)==2:
        pathInfo()
    else:
        print("Incorrect number of params")
  