Option(5) map { x =>
  x + 10
} map { x =>
  x * 2
} filter { x =>
  x > 10
} map { x =>
  println("x is greater than 10")
} getOrElse {
  println("x is less than or equal to 10")
}