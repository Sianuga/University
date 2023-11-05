import pytest
from Ex2 import RejectedPasswordLog, AcceptedPasswordLog, ErrorLog, OtherLog
from Ex4 import SSHLogJournal
import Ex3

def all_criteria(log_entry: Ex3.SSHLogEntry) -> bool:
    return True

@pytest.mark.parametrize("logEntry, expected", [("Apr 17 09:22:57 debian sshd[1871]: Accepted password for user1 from 192.168.1.2 port 5678 ssh2",AcceptedPasswordLog),
 ("Dec 10 06:55:48 LabSZ sshd[24200]: Failed password for invalid user webmaster from 173.234.31.186 port 38926 ssh2",RejectedPasswordLog),
   ("Dec 10 07:51:20 LabSZ sshd[24326]: error: Received disconnect from 195.154.37.122: 3: com.jcraft.jsch.JSchException: Auth fail [preauth]" ,ErrorLog),
    ( "Dec 10 06:55:46 LabSZ sshd[24200]: reverse mapping checking getaddrinfo for ns.marryaldkfaczcz.com [173.234.31.186] failed - POSSIBLE BREAK-IN ATTEMPT!",OtherLog)])
def test_append_type_check(logEntry, expected):
    journal = SSHLogJournal()
    journal.append(logEntry)
    logs = journal.getLogs(all_criteria)
    assert isinstance(logs[0], expected)