import re
from datetime import datetime

def processLogFile(logFilePath):
    logList = []

    with open(logFilePath, 'r', errors='ignore') as logFile:
        lines = logFile.readlines()

        if parseHTTPEntry(lines[0]) is not None:
            parse = parseHTTPEntry
        elif parseSSHEntry(lines[0]) is not None:
            parse = parseSSHEntry
        else:
            return None

        for line in lines:
            logDict = parse(line)
            if logDict is not None:
                logList.append(logDict)
        return logList

def parseHTTPEntry(individualLog):
    regex = r'^([\d.]+|\S+) \S+ \S+ \[(\d{2}/\w{3}/\d{4}:\d{2}:\d{2}:\d{2} [+-]\d{4})\] "(\S+) (\S+) \S+" (\d{3}) (\S+)$'
    match = re.match(regex, individualLog)
    if match:
        ipAddress = match.group(1)
        timestamp = match.group(2)
        requestMethod = match.group(3)
        requestPath = match.group(4)
        statusCode = int(match.group(5))
        if match.group(6) == '-':
            responseSize = 0
        else:
            responseSize = int(match.group(6))
        timestamp = datetime.strptime(timestamp, '%d/%b/%Y:%H:%M:%S %z')
        entry = {
            "ipAddress": ipAddress,
            "timestamp": timestamp,
            "requestMethod": requestMethod,
            "requestPath": requestPath,
            "statusCode": statusCode,
            "responseSize": responseSize,
            "raw": individualLog
        }
        return entry
    return None

def parseSSHEntry(individualLog):
    regex = r'(\w+\s+\d+\s+\d+:\d+:\d+)\s+(\S+)\s+(\S+)\[(\d+)\]:\s+(.*)'
    matches = re.match(regex, individualLog)

    if matches:
        timestamp = datetime.strptime(matches.group(1), '%b %d %H:%M:%S')
        hostname = matches.group(2)
        application = matches.group(3)
        pid = int(matches.group(4))
        message = matches.group(5)

        logEntry = {
            'timestamp': timestamp,
            'hostname': hostname,
            'application': application,
            'pid': pid,
            'message': message,
            'raw': individualLog
        }

        return logEntry
    return None