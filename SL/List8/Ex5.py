import re
import Ex3

class SSHUser:
    def __init__(self, log: Ex3.SSHLogEntry, last_login: str)->None:
        self.username:str = log.getUserFromLog()
        self.last_login:str = last_login
 
    def validate(self, log: Ex3.SSHLogEntry) -> bool:
        
        if self.username in log.getUserFromLog():
            return True
        else:
            return False