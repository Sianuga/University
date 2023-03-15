import sys

def main(file):


    for line in file:

        splitLine = line.split()

        try:
            if(splitLine[-2]=='200'):
                print(line)
        except IndexError: continue
 



if __name__ == '__main__':
    file = sys.stdin
    main(file)