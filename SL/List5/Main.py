import Ex1 

entry = "Dec 10 06:55:46 LabSZ sshd[24200]: reverse mapping checking getaddrinfo for ns.marryaldkfaczcz.com [173.234.31.186] failed - POSSIBLE BREAK-IN ATTEMPT!"

log = Ex1.SSHLogEntry(entry)
print(log.getIPv4Address())
print(log)