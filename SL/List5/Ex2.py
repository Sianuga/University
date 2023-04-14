import Ex1
from enum import Enum

class messageType(Enum):
    LOGIN_SUCCES = "session opened"
    LOGIN_FAILED = "authentication failure"
    LOGOUT = "session closed"
    INCORRECT_PASSWORD = "Failed password"
    INCORRECT_USERNAME = "Invalid user"
    BREAKIN_ATTEMPT = "POSSIBLE BREAK-IN ATTEMPT"
    OTHER = ""

def getMessageType(description):
    for message in messageType:
        if message.value in description:
            return message.name

class SSHLogEntry_Rejected(Ex1.SSHLogEntry):

    def __init__(self, logEntry):
        super().__init__(logEntry)
        self.messageType = getMessageType(self.Description)

class SSHLogEntry_Accepted(Ex1.SSHLogEntry):
    pass 

class SSHLogEntry_Failed(Ex1.SSHLogEntry):
    pass

class SSHLogEntry_Other(Ex1.SSHLogEntry):
    pass