def types[A](x: A) =
{
  x match
  {
    case x:Int => 0
    case x:String => "Hello world"
    case _ => "Can not know which type you have"
  }
}
