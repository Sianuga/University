import Ex2, Ex3





def main():
    tupleList = Ex2.read_log()
    
    print("Sort_log: ")
    sortedList = Ex2.sort_log(tupleList[:5],0)  
    print(sortedList)  
    sortedList = Ex2.sort_log(tupleList[:10],-71)

    print("Get by address: ")
    addrList = Ex2.get_entries_by_addr(tupleList, "199.120.110.21")
    Ex2.print_entries(addrList)

    print("Get by code: ")
    codeList = Ex2.get_entries_by_code(tupleList,200)
    Ex2.print_entries(codeList)

    print("Get by failed: ")
    failsList = Ex2.get_failed_reads(tupleList,True)
    Ex2.print_entries(failsList)

    print("Get by extension: ")
    extensionList = Ex2.get_entries_by_extension(tupleList,"html")
    Ex2.print_entries(extensionList)

 

    print("EntryToDict:")
    entry = Ex3.entry_to_dict(tupleList[0])
    print(entry)
    

    print("LogToDict:")
    dict = Ex3.log_to_dict(tupleList)
    print(dict)

    print("Get addr:")
    keys = Ex3.get_addrs(dict)
    print(keys)

    print("Print:")
    Ex3.print_dict_entry_dates(dict)


if __name__ == '__main__':
    main()