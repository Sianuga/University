import Ex3, Ex2


def convToLogObj(log) -> Ex3.SSHLogEntry:
    for ssh_log_entry_class in Ex3.SSHLogEntry.__subclasses__():
        if ssh_log_entry_class.validate(log):
            return ssh_log_entry_class(log)
    return Ex2.OtherLog(log)


class SSHLogJournal:
    def __init__(self):
        self.logs = []

    def append(self, logEntry: str):
        log_obj = convToLogObj(logEntry)

        self.logs.append(log_obj)

    def getLogs(self, criteria):
        res = []
        for log in self.logs:
            if criteria(log):
                res.append(log)

        return res

    def __len__(self):
        return len(self.logs)

    def __iter__(self):
        return iter(self.logs)

    def __contains__(self, logEntry):
        return logEntry in self.logs
