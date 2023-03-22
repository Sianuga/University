

def entry_to_dict(entry):
    return   {"ip/address": entry[0],
            "timestamp": entry[1],
            "request_method": entry[2],
            "path": entry[3],
            "status_code": entry[4],
            "response_size": entry[5]}


def print_dict(dict):
    for key, value in dict.items():
        print(key, " : ", value)


def log_to_dict(logList):
    logDict = {}
    for entry in logList:
        ip = entry[0]
        if ip not in logDict:
            logDict[ip] = []
        entry_dict = entry_to_dict(entry)
        logDict[ip].append(entry_dict)
    return logDict

def get_addrs(logDict):
    return list(logDict.keys())


from datetime import datetime

def print_dict_entry_dates(logDict):
    for ip, entries in logDict.items():
        num_entries = len(entries)
        first_request = entries[0]["timestamp"].timestamp()
        last_request = entries[-1]["timestamp"].timestamp()
        successful_requests = 0
        for entry in entries:
            if entry["status_code"] == 200:
                successful_requests += 1
        success_ratio = successful_requests / num_entries
        print("IP/Address:", ip)
        print("Number of Requests:", num_entries)
        print("First Request:", datetime.fromtimestamp(first_request).strftime('%Y-%m-%d %H:%M:%S'))
        print("Last Request:", datetime.fromtimestamp(last_request).strftime('%Y-%m-%d %H:%M:%S'))
        print("Success Ratio:", success_ratio)
        print("")

