import scala.::
import scala.annotation.tailrec
import scala.collection.immutable.Nil.:::

sealed trait Tree
final case class Empty() extends Tree
case class Node(value: Int, lNode: Tree, rNode: Tree) extends Tree

def returnInOrder(tree: Tree): List[Int] =
{
  tree match
  {
    case Empty() => Nil
    case Node(value,Empty(), Empty()) => List(value)
    case Node(value,lNode,rNode) => returnInOrder(lNode):::List(value):::returnInOrder(rNode)
  }
}

def sumTree_Aux(treeInOrder: List[Int], sum: Int):Int =
{
  treeInOrder match
  {
    case h::t => sumTree_Aux(t,h+sum)
    case Nil => sum
  }
}

def sumTree(tree: Tree): Int =
{
 sumTree_Aux(returnInOrder(tree),0)
}


//def a(left : Tree, right: Tree, sum:Int): Int =
//{
//  (left,right) match
//  {
//    case (Empty(),Empty()) => 0
//    case (Node(value,Empty(), Empty()),Node(value_2,Empty(), Empty())) => value
//    case Node(value,lNode,rNode) => a(lNode,rNode,value+sum)
//  }
//}

val treeTest1 = Node(1
  ,Node(2
    ,Node(4
      ,Empty()
      ,Empty())
    ,Empty())
  ,Node(3
    ,Node(5
      ,Empty()
      ,Node(6
        ,Empty()
        ,Empty()))
    ,Empty()))

val treeTest2 = Empty();

  val treeTest3 = Node(-2, Empty(), Empty())

sumTree(treeTest1)
sumTree(treeTest2)
sumTree(treeTest3)





def g(xs: Any)=
  {
    xs match
    {
      case (a::b)::c => true
      case _ => false
    }

  }

g((1::Nil) :: (2::Nil) :: Nil ::Nil)
g(List(1,2,3)::List(2,3,4))
g((1,2,3)::(3,4,5)::Nil)


class C
{
  def wykonaj: String = "C"
}
class B extends C
{
  override def wykonaj:String = "B"
}

class A extends B
{
  override def wykonaj:String = "A"
}


val b: B= new B();
val ab: C= b.asInstanceOf[C];
val ac: C = new A();

b.wykonaj;
ab.wykonaj;
ac.wykonaj;


@tailrec
def fib(number: Int, acc: Int, add: Int): Int =
{
  number match
  {
    case number if number<=0 => add;
    case _ => fib(number-1, acc+add,acc);
  }
}

fib(3,1,0)


@tailrec
def sil(number: Int, acc: Int):Int =
{
  number match
    {
    case number if number<=0 => acc;
    case _ => sil(number-1, acc*number)
  }
}

sil(3,1)