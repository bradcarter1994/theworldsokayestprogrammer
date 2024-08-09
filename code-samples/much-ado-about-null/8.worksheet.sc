val maybeAnInt: Option[Int] = Option(5)
// val maybeAnInt: Option[Int] = None

maybeAnInt map { theInt =>
  val doubled = theInt * 2
  println(doubled)
} getOrElse {
  println("Not A Number")
}