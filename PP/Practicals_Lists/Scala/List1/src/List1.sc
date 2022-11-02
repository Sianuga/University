def nameConnector(name: List[String], connector: String ) : String =
{
  if(name!=Nil)
    {
      if(name.tail!=Nil)
      {
        name.head + connector + nameConnector(name.tail,connector)
      }
      else
      {
        name.head
      }
    }
  else
    {
      ""
    }


}

def adder(numbers: List[Double]):Double =
{
  if(numbers!=Nil)
    {
      numbers.head + adder(numbers.tail)
    }
  else
    {
      0
    }
}

nameConnector(List("To","jest","napis"),"-")
nameConnector(List("A","B","C"),"+")
nameConnector(List("1","2","3"),"")
nameConnector(Nil,"")



adder(List(5.0,-3.0,4.0))
adder(List(0,-3.0,1242141.0))
adder(List(-2.1,-3.0,-4.3))