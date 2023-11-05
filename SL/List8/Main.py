import Ex1,Ex3,Ex2 ,Ex4, Ex5


# Stworzenie obiektu klasy SSHLogJournal
log_journal = Ex4.SSHLogJournal()

# Dodanie kilku wpisów do dziennika logów SSH
log_journal.append('Apr 17 09:22:57 debian sshd[1871]: Accepted password for user1 from 192.168.1.2 port 5678 ssh2')
log_journal.append('Apr 17 09:23:06 debian sshd[1873]: Failed password for invalid user user2 from 192.168.1.3 port 5679 ssh2')
log_journal.append('Apr 17 09:24:14 debian sshd[1875]: error: maximum authentication attempts exceeded for root from 192.168.1.4 port 5680 ssh2')
log_journal.append('Apr 17 09:25:20 debian sshd[1877]: Disconnecting invalid user user3 192.168.1.5 port 5681: Too many authentication failures')

# Wyświetlenie wszystkich wpisów w dzienniku logów SSH
for log in log_journal.logs:
    print(repr(log))

# Wyświetlenie wszystkich wpisów związanych z błędami
print('Error logs:')
for log in log_journal.getLogs(lambda x: isinstance(x, Ex2.ErrorLog)):
    print(log)

# Wyświetlenie wszystkich wpisów związanych z odrzuconymi hasłami
print('Rejected password logs:')
for log in log_journal.getLogs(lambda x: isinstance(x, Ex2.RejectedPasswordLog)):
    print(log)

# Wyświetlenie wszystkich wpisów związanych z zaakceptowanymi hasłami
print('Accepted password logs:')
for log in log_journal.getLogs(lambda x: isinstance(x, Ex2.AcceptedPasswordLog)):
    print(log)

# Wyświetlenie wszystkich wpisów z adresem IPv4
print('Logs with IPv4 address:')
for log in log_journal.getLogs(lambda x: x.getIPv4Address() is not None):
    print(log)

# Stworzenie obiektów klasy SSHUser

print("Duck typing:")

users = []

for entry in log_journal.logs:
    if isinstance(entry, Ex2.AcceptedPasswordLog) or isinstance(entry, Ex2.RejectedPasswordLog):
        user = Ex5.SSHUser(entry,entry.Date)
        users.append(user)



log = log_journal.logs[0]
log2 = log_journal.logs[1]

for user in users:
    print("The user validation is: "+str(user.validate(log)))

