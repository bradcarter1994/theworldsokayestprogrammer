val chessBoardSquares: Seq[String] = for {
  row <- 1 to 8 if row % 2 == 0
  column <- 'A' to 'H'
} yield s"$row$column"

println(chessBoardSquares)