import scala.annotation.tailrec


def lwybierzAux[A](lazyList: LazyList[A],n:Int,i:Int):LazyList[A] =
  {
    (lazyList,i) match
    {
      case(LazyList(),_) => LazyList()
      case (_#::t,1) => lwybierzAux(t,n,i+1)
      case (h#::t,n) => h#:: lwybierzAux(t,n,1)
    }
  }


def lwybierz[A](lazyList: LazyList[A], n: Int, start: Int): LazyList[A] =
{
  if(n<=0) throw new Exception("Incorrect value")
  (lazyList,start) match
  {
    case (LazyList(),_) => LazyList()
    case (h#::t,1) => h#::lwybierzAux(t,n,1)
    case (h#::t,_) => lwybierz(t,n,start-1)
  }
}

lwybierz(LazyList(5,6,3,2,1),2,1).force
lwybierz(LazyList(),2,1).force
lwybierz(LazyList(5,6,3,2,1),1,3).force

