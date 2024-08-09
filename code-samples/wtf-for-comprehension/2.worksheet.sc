val either1: Either[String, Int] = Right(4)
val either2: Either[String, Int] = Right(6)
val either3: Either[String, Int] = Left("Banana")

val result: Either[String, Int] = for {
  int1 <- either1
  int2 <- either2
  int3 <- either3
} yield int1 * int2 * int3

println(result)