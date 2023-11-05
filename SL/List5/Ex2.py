import Ex3
from enum import Enum
import re




class RejectedPasswordLog(Ex3.SSHLogEntry):

    @staticmethod
    def validate(log):
        return 'Failed password for' in log

    def __init__(self, logEntry):
        super().__init__(logEntry)

    def getUsername(self):
  
        usernamePattern = r'Failed password for invalid user (\S+)'
        match = re.search(usernamePattern, self.Description)
        if match:
            return match.group(1)
        else:
            return None
        

class AcceptedPasswordLog(Ex3.SSHLogEntry):

    @staticmethod
    def validate(log):
        return 'Accepted password for' in log

    def __init__(self, logEntry):
        super().__init__(logEntry)

    def getUsername(self):
        
        usernamePattern = r'Accepted password for (\S+)'
        match = re.search(usernamePattern, self.Description)
   
        if match:
            return match.group(1)
        else:
            return None

class ErrorLog(Ex3.SSHLogEntry):

    def validate(log):
        return 'error:' in log

    def __init__(self, logEntry):
        super().__init__(logEntry)

    def getErrorMessage(self):
       
        errorPattern = r':\s+(.*)$'
        match = re.search(errorPattern, self.Description)
        if match:
            return match.group(1)
        else:
            return None

class OtherLog(Ex3.SSHLogEntry):

    @staticmethod
    def validate(log):
        return True

    def __init__(self, logEntry):
        super().__init__(logEntry)

    def __str__(self):
        return f"Other SSH Log: {super().__str__()}"