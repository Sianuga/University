import sys 
import os
import re
import Ex2,Ex3,Ex4
import logging



def Ex1(filePath):

    lines = readFile(filePath)
    print("Ex3 logTheMessage")
    dictList = []
    for line in lines:
        dictList.append(Ex2.changeToDict(line))
        Ex3.logTheMessage(line)
    
    print("Ex2 changeToDict")

    for dict in dictList:
        print(dict)


    testFunc = [Ex2.get_ipv4s_from_log, Ex2.get_user_from_log]

    for func in testFunc:
        print("Ex2 " + func.__name__)
        for line in lines:
            print(func(line))

    print("Ex2 get_message_type")
    for dict in dictList:
        print(Ex2.get_message_type(dict["Description"]))

    print("Ex4 getRandomUserLogs")
    print(Ex4.getRandomUserLogs(dictList,2))
    print("Ex4 calculateUserLoginFrequency")
    print(Ex4.calculateUserLoginFrequency(dictList))
    print("Ex4 getSSHDurationStats")
    print(Ex4.getSSHDurationStats(dictList))

def readFile(filePath):
    f = open(filePath, "r")
    lines = f.readlines()
    f.close()
    return lines


 


    

















if __name__=="__main__":
    
    if(os.path.isfile(sys.argv[1])):
        Ex1(sys.argv[1])
    else:
        print("File not found")