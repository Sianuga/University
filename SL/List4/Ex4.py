import random
import datetime
import statistics
import Ex2

def getRandomUser(logDicts):
    users = {}
    for logDict in logDicts:
        user = Ex2.get_user_from_log(Ex2.changeToLog(logDict))
        if user not in users:
            users[user] = 0
        else:
            users[user] += 1
           

    return random.choice(list(users.keys()))


def getRandomUserLogs(logDicts, n=1):
    user = getRandomUser(logDicts)
    logs = []
    for logDict in logDicts:
        logs.append(Ex2.changeToLog(logDict))

    userLogs = []

    for log in logs:
        if Ex2.get_user_from_log(log) == user:
            userLogs.append(log)

    if n > len(userLogs):
        return None
    
    return random.sample(userLogs, n)

def getSSHDurationStats(logDicts):
    
    globalMean = 0
    globalDev = 0
    userMean = {} 
    userDev = {}

    info = []

    for logDict in logDicts:
        user = Ex2.get_user_from_log(Ex2.changeToLog(logDict))

        if user is not None:
            info.append((logDict['Date'], user, Ex2.get_message_type(logDict['Description'])))

    info.sort(key=lambda x: x[0])

    globalDurations = []
    userDurations = {}

    startTime = {}
    

    for (timestamp, user, message_type) in info:
        if message_type == Ex2.messageType.LOGIN_SUCCES.name:
            startTime[user] = datetime.datetime.strptime(timestamp, "%b %d %H:%M:%S")
        elif message_type == Ex2.messageType.LOGOUT.name:
            endTime = datetime.datetime.strptime(timestamp, "%b %d %H:%M:%S")
            duration = (endTime - startTime[user]).total_seconds()
            globalDurations.append(duration)
            if user not in userDurations:
                userDurations[user] = []
            userDurations[user].append(duration)





    globalMean = statistics.mean(globalDurations)
    globalDev = statistics.stdev(globalDurations)
    
    for user in userDurations.keys():
        userMean[user] = statistics.mean(userDurations[user])
        userDev[user] = statistics.stdev(userDurations[user])


    return {

        'global': {
            'mean': globalMean,
            'std_dev': globalDev
        },
        'users': {
            
            'mean': userMean,
            'std_dev': userDev

        },
    }

def calculateUserLoginFrequency(logDicts):
    userFreq = {}
    users = []
    for logDict in logDicts:
        user = Ex2.get_user_from_log(Ex2.changeToLog(logDict))
        users.append(user)

    for user in users:
        if user is not None:
            if user in userFreq:
                userFreq[user] += 1
            else:
                userFreq[user] = 1

    maxFreq = max(userFreq.values())
    minFreq = min(userFreq.values())

    return {'mostFrequent': [user for user in userFreq if userFreq[user] == maxFreq],
            'maxFreq': maxFreq,
            'leastFrequent': [user for user in userFreq if userFreq[user] == minFreq],
            'minFreq': minFreq,}


