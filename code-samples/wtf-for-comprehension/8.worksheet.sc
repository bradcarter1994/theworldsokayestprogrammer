val chessBoardSquares: Seq[String] = for {
  row <- 1 to 8
  column <- 'A' to 'H'
  lowercaseColumn = column.toLower
} yield s"$row$lowercaseColumn"

println(chessBoardSquares)