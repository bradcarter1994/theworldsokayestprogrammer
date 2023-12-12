def mySqrt: PartialFunction[Double, Double] = {
  case x if x >= 0 => math.sqrt(x)
}

val input = 4

if (mySqrt.isDefinedAt(input)) s"The squareroot of $input is ${mySqrt(4)}"
else "You can't take the square root of a negative number"