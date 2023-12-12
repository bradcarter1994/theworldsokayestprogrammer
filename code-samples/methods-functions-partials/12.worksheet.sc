def mySqrt: PartialFunction[Double, Double] = {
  case x if x >= 0 => math.sqrt(x)
}

val myOptionalSqrt: Double => Option[Double] = mySqrt.lift

myOptionalSqrt(4)

myOptionalSqrt(-4)