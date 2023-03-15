import os 
import sys

def main(file):
    path = ''
    graphics = ['.gif','.jpg','.jpeg','.xbm']
    graphicsSize=0
    otherSize =0

    for line in file:
        splitLine = line.split()
        try:
            path = splitLine[6]    
            filename, fileExtension = os.path.splitext(path)
            if fileExtension in graphics:
                graphicsSize+= int(splitLine[-1])
            else:
                otherSize+= int(splitLine[-1])
        except (ValueError,IndexError) : continue

    print(graphicsSize, otherSize)
    

if __name__ == '__main__':
    file = sys.stdin
    main(file)