import os 
import sys


def printEqualParamEnvVar():
    envVar = os.environ
    params = sys.argv
    filteredArgs= []

    if(len(params)>1):
        for key,value in envVar.items():
            for param in params:
                if param in key:
                    filteredArgs.append((key,value))


    sorted(filteredArgs)

    for key,value in filteredArgs:
        print(key + "=" + value)

if __name__ == "__main__":
    printEqualParamEnvVar()


