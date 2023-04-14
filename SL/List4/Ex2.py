import re
from enum import Enum 
import os 
import sys
import Ex1

class messageType(Enum):
    LOGIN_SUCCES = "session opened"
    LOGIN_FAILED = "authentication failure"
    LOGOUT = "session closed"
    INCORRECT_PASSWORD = "Failed password"
    INCORRECT_USERNAME = "Invalid user"
    BREAKIN_ATTEMPT = "POSSIBLE BREAK-IN ATTEMPT"
    OTHER = ""

def changeToDict(line):
    lineRegex = re.compile(r'^(\w{3}\s\d{1,2}\s\d{2}:\d{2}:\d{2})\s(\w+)\s(\w+)\[(\d+)\]:\s(.*)$')
    line = line.strip()
    match = lineRegex.match(line)
    if match:
        return {
            "Date": match.group(1),
            "Host": match.group(2),
            "AppC": match.group(3),
            "PID": match.group(4),
            "Description": match.group(5)
        }
    else:
        return None
    
def changeToLog(logDict):
    if logDict is None:
        return None
    return logDict["Date"] + " " + logDict["Host"] + " " + logDict["AppC"] + "[" + logDict["PID"] + "]: " + logDict["Description"]
    

def get_ipv4s_from_log(line):
    line = line.strip()
    regex = re.compile(r'^(\w{3}\s\d{1,2}\s\d{2}:\d{2}:\d{2})\s(\w+)\s(\w+)\[(\d+)\]:\s(.*?)(\b(?:\d{1,3}\.){3}\d{1,3}\b|$)')
    match = regex.match(line)
    if match:
        return match.group(6)
    else: 
        return None

def get_user_from_log(line):
    match = None
    lineRegex = re.compile(r'^(\w{3}\s\d{1,2}\s\d{2}:\d{2}:\d{2})\s(\w+)\s(\w+)\[(\d+)\]:\s.*\buser (\S+)')
    if line is not None:
        line = line.strip()
        match = lineRegex.match(line)

    if match:
        return match.group(5)
    else:
        return None

def get_message_type(description):
    for message in messageType:
        if message.value in description:
            return message.name


    
  

    
