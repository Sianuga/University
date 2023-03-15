import sys

def main(file):
    
    sum= 0

    for line in file:

        splitLine = line.split()

        try:
            sum+=int(splitLine[-1])
        except (ValueError,IndexError): continue


    print( sum / (2**30))

if __name__ == '__main__':
    file = sys.stdin
    main(file)