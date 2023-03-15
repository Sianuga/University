import sys
import datetime

def main(file):


    for line in file:

        splitLine = line.split()

        try:
            domainCountry = splitLine[0].split('.')[-1]
            if(domainCountry == "pl"):
                print(line)
            
        
        except (IndexError, ValueError): continue
        
        
 



if __name__ == '__main__':
    file = sys.stdin
    main(file)