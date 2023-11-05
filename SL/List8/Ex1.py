import re
import ipaddress
from typing import AnyStr

class SSHLogEntry:
 
    def __init__(self, logEntry: str) -> None:
        lineRegex = re.compile(r'^(\w{3}\s\d{1,2}\s\d{2}:\d{2}:\d{2})\s(\w+)\s(\w+)\[(\d+)\]:\s(.*)$')
        logEntry= logEntry.strip()
        match: (re.Match[str] | None) = lineRegex.match(logEntry)
        if match:   
            self.Date=match.group(1)
            self.Host=match.group(2)
            self.AppC=match.group(3)
            self.PID=match.group(4)
            self.Description=match.group(5)
        else:
            raise Exception('Invalid log entry')
    
    

    
    def getIPv4Address(self) -> str:
        ipRegex = re.compile(r'(\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})')
        match: (re.Match[str] | None) = ipRegex.search(self.Description)
        if match:
            ip = match.group(1)
            try:
                ipaddress.IPv4Address(ip)
                return ip
            except ipaddress.AddressValueError:
                pass
        return ""