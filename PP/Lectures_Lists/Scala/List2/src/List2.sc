//Exercise 1
def evenR (a: Int): Unit =
{
  def oddR (a: Int): Unit =
  {
    println("AAAAA")
    if(a==0)
    {
      false
    }
    else
    {
      evenR(a-1)
      println("B")
    }
  }


  println("AAAAA")
  if(a==0)
  {
    return true;
  }
  else
  {
    oddR(a-1)
    println("B")
  }
}

evenR(3)

//Exercise 2





def fib (n: Int): Int =
{
  n match
  {
    case 0 => 0
    case 1 => 1
    case _ => fib(n-2)+fib(n-1)
  }
}

def fibTail(n: Int): Int=
  {
    def fibTail_iter(k: Int, firstElem: Int, secondElem: Int): Int =
      {
        k match
        {
          case 0=> firstElem
          case 1=> secondElem
          case _ => fibTail_iter(k-1,secondElem, firstElem+secondElem)
        }
      }

      fibTail_iter(n,0,1)
  }

fib(42)
fibTail(42)

//Exercise 3
//Exercise 4
def pattern[A](x:List[A]):Int =
  {
    x match
    {
      case List(_,_,0,_,_) => 0
      case List((_,_),(0,_)) => 1
    }
  }
//Exercise 5
//Exercise 6

def replaceNth[A](list: List[A], n: Int,x: A): List[A] =
{
 list match
  {
    case Nil => Nil
    case h::t =>
    if(n>0)
    {
     list.head::replaceNth(list.tail,n-1,x)
    }
    else
      {
        x::list.tail
      }

  }

}
replaceNth(List(3,4,5,6),3,7)

