

def acronym(acronymList):

    match acronymList:
        case None: return ""
        case [x]: return  x[0]    
        case [x, *xs]: return x[0] + acronym(xs)



def sortList(sortingList):

    def insert(x, sortedList):
        match sortedList:
            case None: return [x]
            case [y]: 
                if x <= y:
                    return [x, y]
                else:
                    return [y, x]
            case [y, *ys]:
                if x <= y:

                    return [x, y] + ys
                else:
                    return [y] + insert(x, ys)
   

    def sortListAux(sortingList, sortedList):

        match sortingList:
            case None: return sortedList
            case [x]: return insert(x, sortedList)
            case [x, *xs]:

                return sortListAux(xs, insert(x, sortedList))
    
    return sortListAux(sortingList, None)

    

def median(medianList):
        

    match medianList:
        case None: return None
        case [x]: return x
        case [x, *xs]:
            
            match len(medianList) % 2:
                case 1: return medianList[len(medianList)//2]
                case 0: return (medianList[len(medianList)//2-1]+medianList[len(medianList)//2])/2




    
def pierwiastek(x, epsilon):

    def pierwiastekPetla(x, epsilon, y):

      return y if abs(y**2 - x) < epsilon else pierwiastekPetla(x, epsilon, (y + x/y) / 2)
 


    y = x / 2 

    return pierwiastekPetla(x, epsilon, y)


    

def makeAlphaDict_alt(string):
    if string is None:
        return None

    dict = {}

    splitString = string.split(" ")

    for word in splitString:
        for letter in word:
            if letter not in dict:
                dict[letter] = [word]
            else:
                if word not in dict[letter]:
                    dict[letter].append(word)

    return dict


def makeAlphaDict(string):
    words = string.split()
    return {char: [word for word in words if char in word] for char in set("".join(words))}

def flatten(flattenedList):
    
    match flattenedList:
        case None: return None
        case [x]:
            match x:
                case [y, *ys]: return flatten(y)
                case _ : return [x]
                
       
        case [x, *xs]: 
            match x:
                case [y, *ys]: return flatten(x) + flatten(xs)
                case _ : return [x] + flatten(xs)
 
 
                

           


    # if flattenedList is None:
    #     return None
    # if len(flattenedList) == 1 and type(flattenedList[0]) is not list:
    #     return [flattenedList[0]]
    # elif len(flattenedList)==1 and type(flattenedList[0]) is list:
    #     return flatten(flattenedList[0])
    # elif type(flattenedList[0]) is list:
    #     return flatten(flattenedList[0]) + flatten(flattenedList[1:])
    # else:
    #     return [flattenedList[0]] + flatten(flattenedList[1:])
    

