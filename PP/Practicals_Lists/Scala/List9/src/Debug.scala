trait Debug
{
  def debugName(): Unit =
  {
    println(s"Klasa: ${this.getClass.getName}")
  }

  def debugVars(): Unit =
  {
    val fields = this.getClass.getDeclaredFields()
    fields.foreach
    {
      f =>
      f.setAccessible(true)
      println(s"Pole: ${f.getName} => ${f.getType.getSimpleName}, ${f.get(this)}")
    }
  }
}
