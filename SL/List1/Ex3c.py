import sys


def main(file):
    maxSize = 0
    path = ''

    for line in file:

        splitLine = line.split()

        try:
            if int(splitLine[-1]) > maxSize:
                maxSize = int(splitLine[-1])
                path = splitLine[6]
        except (IndexError, ValueError): continue 
    
    print (path, maxSize)

if __name__ == '__main__':
    file = sys.stdin
    main(file)