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
