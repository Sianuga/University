import re

class SSHLogEntry:
 
    def __init__(self, logEntry):
        lineRegex = re.compile(r'^(\w{3}\s\d{1,2}\s\d{2}:\d{2}:\d{2})\s(\w+)\s(\w+)\[(\d+)\]:\s(.*)$')
        logEntry = logEntry.strip()
        match = lineRegex.match(logEntry)
        if match:   
            self.Date=match.group(1)
            self.Host=match.group(2)
            self.AppC=match.group(3)
            self.PID=match.group(4)
            self.Description=match.group(5)
        else:
            raise Exception('Invalid log entry')
    
    def __str__(self):
        return self.Date + ' ' + self.Host + ' ' + self.AppC + '[' + self.PID + ']: ' + self.Description
    
    def getIPv4Address(self):
        ipRegex = re.compile(r'(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})')
        match = ipRegex.search(self.Description)
        if match:
            return match.group(1)
        else:
            return None
    
