import Ex3, Ex2
import typing


def convToLogObj(log: str) -> Ex3.SSHLogEntry:

    for ssh_log_entry_class in Ex3.SSHLogEntry.__subclasses__():
        if ssh_log_entry_class.validate(log):
            return ssh_log_entry_class(log)
    return Ex2.OtherLog(log)


class SSHLogJournal:
    def __init__(self) -> None:
        self.logs: typing.List[Ex3.SSHLogEntry] = []

    def append(self, logEntry: str) -> None:
        log_obj: Ex3.SSHLogEntry = convToLogObj(logEntry)
        self.logs.append(log_obj)

    def getLogs(self, criteria: typing.Callable[[Ex3.SSHLogEntry], bool]) -> typing.List[Ex3.SSHLogEntry]:
        res: typing.List[Ex3.SSHLogEntry] = []
        for log in self.logs:
            if criteria(log):
                res.append(log)
        return res

    def __len__(self) -> int:
        return len(self.logs)

    def __iter__(self) -> typing.Iterator[Ex3.SSHLogEntry]:
        return iter(self.logs)

    def __contains__(self, logEntry: Ex3.SSHLogEntry) -> bool:
        return logEntry in self.logs