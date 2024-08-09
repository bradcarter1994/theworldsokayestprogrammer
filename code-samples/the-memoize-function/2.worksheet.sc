def fibonacci(n: Int): Int = n match {
  case 0 | 1 => 1
  case n =>  fibonacci(n - 1) + fibonacci(n - 2)
}

fibonacci(6)