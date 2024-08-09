val chessBoardSquares: Seq[String] = for {
  row <- 1 to 8
  column <- 'A' to 'H'
  layer <- List("red", "blue", "green")
} yield s"$row$column-$layer"

println(chessBoardSquares)