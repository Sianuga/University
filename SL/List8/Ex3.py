import re
from abc import ABC, abstractmethod
from typing import AnyStr

class SSHLogEntry(ABC):
 
    def __init__(self, logEntry: str) -> None:
        lineRegex= re.compile(r'^(\w{3}\s\d{1,2}\s\d{2}:\d{2}:\d{2})\s(\w+)\s(\w+)\[(\d+)\]:\s(.*)$')
        logEntry = logEntry.strip()
        match= lineRegex.match(logEntry)
        if match:   
            self.Date=match.group(1)
            self.Host=match.group(2)
            self.AppC=match.group(3)
            self.PID=match.group(4)
            self.Description=match.group(5)
            self._rawContent = logEntry
        else:
            raise Exception('Invalid log entry')
    
    @staticmethod
    @abstractmethod
    def validate(log: str) -> bool:
        pass
    
    def __str__(self) -> str:
        return self.Date + ' ' + self.Host + ' ' + self.AppC + '[' + self.PID + ']: ' + self.Description
    
    def getIPv4Address(self) -> str:
        ipRegex= re.compile(r'(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})')
        match= ipRegex.search(self.Description)
        if match:
            return match.group(1)
        else:
            return ""
        
    def getUserFromLog(self) -> str:
        match = None
        lineRegex = re.compile(r'^(\w{3}\s\d{1,2}\s\d{2}:\d{2}:\d{2})\s(\w+)\s(\w+)\[(\d+)\]:\s.*\buser (\S+)')
        
        match = lineRegex.match(self._rawContent)
  
        if match:
            return match.group(5)
        else:
            return ""
    

        
    def __repr__(self) -> str:
        return "SSHLogEntry('" + str(self) + "')"
    
    def __eq__(self,other) -> bool:
        return self._rawContent == other._rawContent
    
    def __lt__(self,other) -> bool:
        return self._rawContent < other._rawContent
    

    def __gr__(self,other) -> bool:
        return self._rawContent> other._rawContent
    
    @property
    def has_ip(self) -> bool:
        return self.getIPv4Address() is not None