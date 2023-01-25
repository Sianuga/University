object A
{
  def main(args: Array[String]): Unit =
  {

    println("Zadanie1")
    println()

    var p : Point = new Point(3,4)
    var p1 : Point = new Point(0,0)
    var p2 : Point = new Point(-1,-1)

    p.debugName()
    p1.debugName()
    p2.debugName()

    println()
    println("Zadanie2")
    println()

    p.debugVars()
    p1.debugVars()
    p2.debugVars()

    println()
    println("Zadanie3")
    println()

    Debugger.fields(p);
    Debugger.fields(p1);
    Debugger.fields(p2);
  }

}
