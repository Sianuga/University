import random

class PasswordGenerator:
    
    def __init__(self, length, charset='abcdefghijklmnopqrstuvwxyz0123456789', count=float('inf')):
        self.length = length
        self.charset = charset
        self.count = count
        self.generated = 0
        
    def __iter__(self):
        return self
    
    def __next__(self):
        if self.generated < self.count:
            password = ''.join(random.choice(self.charset) for _ in range(self.length))
            self.generated += 1
            return password
        else:
            raise StopIteration