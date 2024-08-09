import scala.util.{Try, Success, Failure}

val userInput: String = "100"
// val userInput: String = "potato"

val maybeSquareroot: Try[Double] = Try {
  val myDouble = userInput.toDouble
  Math.sqrt(myDouble)
}

maybeSquareroot match {
  case Success(squareroot) => println(s"The square root of $userInput is $squareroot")
  case Failure(exception) => println(s"$userInput isn't a number silly!")
}