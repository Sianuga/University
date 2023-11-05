#Correct cases where iterable is not iterable or is of lenght 0 and other dangers to check same for Ex1

def forall(pred, iterable):
      
        match iterable:
            case None: return True
            case []: return True
            case [x, *xs]: return pred(x) and forall(pred, xs)
             
        


def exists(pred, iterable):
        
        match iterable:
            case None: return False
            case []: return False
            case [x, *xs]: return pred(x) or exists(pred, xs)
             



def atleast(n, pred, iterable):
        
        match iterable:
            case None: return False
            case []: return n <= 0
            case [x, *xs]: 
                return atleast(n-1,pred,xs) if pred(x) else atleast(n,pred,xs)


             
        


def atmost(n, pred, iterable):


    match iterable:
        case None: return True
        case []: return n >= 0
        case [x, *xs]: 
              return atmost(n-1, pred, xs) if pred(x) else atmost(n, pred, xs)

         



        
