val rows = 1 to 8
val columns = 'A' to 'H'
val layers = List("red", "blue", "green")

val chessBoardSquares: Seq[String] = for {
  row <- rows
  column <- columns
  layer <- layers
} yield s"$row$column-$layer"

println(s"${rows.size} X ${columns.size} X ${layers.size} = ${chessBoardSquares.size}")