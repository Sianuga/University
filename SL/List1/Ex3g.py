import sys
import datetime

def main(file):


    for line in file:

        splitLine = line.split()

        try:
            strippedDate = splitLine[3].strip("[")
            dateObj = datetime.datetime.strptime(strippedDate.split(":")[0], '%d/%b/%Y')
            dayOfWeek = dateObj.strftime('%A')
            if(dayOfWeek == "Friday"):
                print(line)
            
        
        except (IndexError, ValueError): continue
        
        
 



if __name__ == '__main__':
    file = sys.stdin
    main(file)