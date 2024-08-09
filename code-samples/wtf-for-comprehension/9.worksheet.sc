val letters: List[Char] = List('A', 'B', 'C')
val numbers: List[Int] = List(1, 2, 3)
val colors: List[String] = List("Red", "Blue", "Green")

val myResult: Seq[String] = for {
  letter: Char <- letters
  number: Int <- numbers
  color: List[String] = colors
} yield s"$letter $number $colors"

myResult foreach println

println(s"myResult.size = ${myResult.size}")