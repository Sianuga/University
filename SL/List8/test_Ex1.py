import Ex1
import pytest

def test_time_extraction():
    log_entry = "Dec 10 06:55:46 LabSZ sshd[24200]: reverse mapping checking getaddrinfo for ns.marryaldkfaczcz.com [173.234.31.186] failed - POSSIBLE BREAK-IN ATTEMPT!"
    entry = Ex1.SSHLogEntry(log_entry)

    assert entry.Date == "Dec 10 06:55:46"


def test_ipv4_extraction_valid_ip():
    log_entry = "Dec 10 06:55:48 LabSZ sshd[24200]: Failed password for invalid user webmaster from 173.234.31.186 port 38926 ssh2"
    entry = Ex1.SSHLogEntry(log_entry)
    assert entry.getIPv4Address() == "173.234.31.186"

def test_ipv4_extraction_invalid_ip():
    log_entry = "Dec 10 06:55:48 LabSZ sshd[24200]: Failed password for invalid user webmaster from 666.777.88.213 port 38926 ssh2"
    entry = Ex1.SSHLogEntry(log_entry)
    print(entry.getIPv4Address())
    assert entry.getIPv4Address() == ""

def test_ipv4_extraction_no_ip():
    log_entry = "Dec 10 06:55:48 LabSZ sshd[24200]: Failed password for invalid user webmaster from example.com port 38926 ssh2"
    entry = Ex1.SSHLogEntry(log_entry)
    assert entry.getIPv4Address() == ""