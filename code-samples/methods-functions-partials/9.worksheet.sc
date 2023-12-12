def mySqrt = new PartialFunction[Double, Double] {
  def apply(x: Double): Double = {
    math.sqrt(x)
  }
  
  def isDefinedAt(x: Double): Boolean = {
    x >= 0
  }
}

val input = 4

if (mySqrt.isDefinedAt(input)) s"The squareroot of $input is ${mySqrt(4)}"
else "You can't take the square root of a negative number"