import sys
import datetime
import pathlib

datetime.datetime

def read_log():

    tupleList =[] 

    date_format = "%d/%b/%Y:%H:%M:%S %z"

    

    for line in sys.stdin:
        splitLine = line.split(" ")
        try:
            singleTuple = (splitLine[0],datetime.datetime.strptime((splitLine[3]+ " "+ splitLine[4]).replace("[","").replace("]",""), date_format), splitLine[5], splitLine[6]+" "+splitLine[7], int(splitLine[8]), int(splitLine[9].strip())) 
            tupleList.append(singleTuple)
        except (IndexError,ValueError): continue 

    return tupleList


def sort_log(tupleList, sortingKey):
    
    sortedList=[]

    try:
        sortedList = sorted(tupleList, key = lambda x:  x[sortingKey])
    except IndexError: print("Incorrect index")


    return sortedList


def get_entries_by_condition(tuplesList, condition):
    foundEntries = []
    for tuple in tuplesList:
        if(condition(tuple)):
            foundEntries.append(tuple)

    return foundEntries;

def get_entries_by_addr(tuplesList, address):
    return get_entries_by_condition(tuplesList, lambda tuple: tuple[0]==address)

def get_entries_by_code(tuplesList, code):
    return get_entries_by_condition(tuplesList, lambda tuple: tuple[-2]==code)

def get_failed_reads(tuplesList, isSplit):
    
    list4xx = get_entries_by_condition(tuplesList, lambda tuple: tuple[-2]<500 and tuple[-2]>=400)
    list5xx = get_entries_by_condition(tuplesList, lambda tuple: tuple[-2]<600 and tuple[-2]>=500)

    if isSplit:
        return list4xx,list5xx
    else:
        return list4xx+list5xx
        

def get_entries_by_extension(tuplesList, extension):
    return get_entries_by_condition(tuplesList, lambda tuple: pathlib.Path(tuple[-3].split(" ")[0]).suffix.replace(".","") == extension)

def print_entries(tuplesList):
    for tuple in tuplesList:
        print(tuple)
