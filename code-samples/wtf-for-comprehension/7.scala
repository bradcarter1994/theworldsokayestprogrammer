def isBlack(row: Int, column: Char): Boolean = (row + column) % 2 == 0

val chessBoardSquares: Seq[String] = for {
  row <- 1 to 8
  column <- 'A' to 'H'
  if isBlack(row, column)
} yield s"$row$column"

println(chessBoardSquares)