import sys
import os
import json



def mostCommonChar(file):

    charCount = {}
    chars = file.read()
    for char in chars:
        if char in charCount:
            charCount[char]+=1
        else:
            charCount[char]=1
    
    
    max = 0
    maxKey = ""

    for key,value in charCount.items():
        if value >= max:
            max = value
            maxKey = key


    return (maxKey,max)

def mostCommonWord(file):

    wordCount = {}
    words = file.read().split()

    for word in words:
        if word in wordCount:
            wordCount[word]+=1
        else:
            wordCount[word]=1
    
    max = 0
    maxKey = ""

    for key,value in wordCount.items():
        if value >= max:
            max = value
            maxKey = key


    return (maxKey,max)


def countChars(f):
    characters = f.read().replace(" ","")
    return len(characters)



def countWords(f):
    words = f.read().split()
    return len(words)

def countLines(f):
    lines = f.readlines()
    return len(lines)
    


def fileInfoToJson(filePath):

    if os.path.isfile(filePath):
        print(params[1])
        with open(params[1], "r") as f:
            f.seek(0)
            numberOfChars = countChars(f)
            f.seek(0)
            numberOfWords = countWords(f)
            f.seek(0)
            numberOfLines = countLines(f)
            f.seek(0)
            mostCommChar = mostCommonChar(f)
            f.seek(0)
            mostCommWord = mostCommonWord(f)


   
        jsonFile = json.dumps({"numberOfChars":numberOfChars,"numberOfWords":numberOfWords,"numberOfLines":numberOfLines,"mostCommonChar":mostCommChar,"mostCommonWord":mostCommWord})

        print(jsonFile)


    else:
        print("Incorrect file path!")

if __name__ == "__main__":
    params = sys.argv
    if len(params) == 2:
        fileInfoToJson(params[1])