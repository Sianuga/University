import sys


def main(file):

    counter= 0
    for line in file:

        splitLine = line.split()

        try:
            if(splitLine[-2]=='302'):
                counter+=1
        except (ValueError,IndexError): continue

    print(counter)

if __name__ == '__main__':
    file = sys.stdin
    main(file)