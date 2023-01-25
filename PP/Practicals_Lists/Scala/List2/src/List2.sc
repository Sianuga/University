def types[A](x: A) =
{
  x match
  {
    case 5 => "five"
    case x:Int if x<=0 => x+1
    case x:Double if x>0 => x+2.5
    case x:String => "Hello world"
    case _ => "Can not know which type you have"
  }
}

types(5.0)
types(5)
types(-1)
types(2.0)
types("A")
types(Nil)

def length[A](list: List[A]):Int =
  {
    list match
    {
      case Nil => 0
      case h::t => 1+length(t)
    }
  }

length(Nil)
length(List(0,1))
length(List("a","b","c"))
length(List(List("a"),List(23,21),List(Nil)))

def factorial(x: Int) =
{
  x match
  {
    case x if x<0 => "wrong input"
    case 0 | 1 => 1
    case _ => x * factorial(x-1)
  }
}