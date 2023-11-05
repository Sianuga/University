import re
import Ex3

class SSHUser:
    def __init__(self, username: str, last_login: str):
        self.username = str(username)
        self.last_login = last_login
 
    def validate(self, log) -> bool:
        
        if self.username in log.getUsername():
            return True
        else:
            return False