
//Ex 1
def flatten1[A](list: List[List[A]]): List[A] =
{
//  if(list!=Nil)
//  {
//  list.head:::flatten1(list.tail)
//  }
//  else
//  Nil
if(list!=Nil)
  {
    if(list.head!=Nil)
    list.head.head::flatten1(list.head.tail::list.tail)
    else
      flatten1(list.tail)
  }
else
  Nil
}


flatten1(List(List(1,2,3),List(4,5),List(6)))

//Ex 2
/*def count[A](elem: A, list: List[A]): Int =
{
//  if(list!=Nil)
//  {
//    if(list.head==elem) 1 + count(elem,list.tail)
//    else 0 + count(elem, list.tail)
//  }
//  else
//  {
//    0
//  }
  list match
  {
    case Nil => 0
    case list.head == elem => 1+ count(elem,list.tail)
    case _ => count(elem,list.tail)
  }




}

count("a", List("a","l","a"))*/
//Ex 3
def replicate[A](x:A,n:Int):List[A] =
{
if(n>0)
  {
    x::replicate(x,n-1)
  }
else
  Nil
}

replicate("A",3)
//Ex 4

def sqrList(list: List[Int]):List[Int]= {
  if (list != Nil)
    (list.head * list.head) :: sqrList(list.tail)
    else
    Nil
}

//Zamiana na funkcje val a =sqrlist_ Function1
sqrList(List(3,4,5))
//Ex 5
def reverse[A](list: List[A]):List[A] =
  {
    /*
    if(list!=Nil)
      {
        reverse(list.tail):::List(list.head)
      }
    else
      {
        Nil
      }*/

    list match
      {
      case Nil => Nil
      case _ => reverse(list.tail):::List(list.head)
     }
  }

reverse(List(1,2,3))

def palindrome[A](list: List[A]):Boolean=
  {
  reverse(list)==list
  }

palindrome(List("k","a","j","a","k"))
//Ex 6
def listLength[A](list: List[A]):Int=
  {
    if(list!=Nil)
    {
      1+listLength(list.tail)
    }
    else
    {
      0
    }
  }

//Ex 7





