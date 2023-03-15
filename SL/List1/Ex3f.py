import sys

def main(file):


    for line in file:

        splitLine = line.split()

        try:
            strippedDate = splitLine[3].strip("[")
            hour = int(strippedDate.split(":")[1])
            if(hour <= 22 and hour >= 6):
                print(line)

        except (IndexError, ValueError): continue
        
 



if __name__ == '__main__':
    file = sys.stdin
    main(file)