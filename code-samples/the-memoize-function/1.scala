def verboseFibonacci(n: Int, tabs: Int = 0): Int = n match {
  case 0 | 1 =>
    println("  " * tabs + s"fibonacci($n) = 1")
    1
  case n => 
    println("  " * tabs + s"fibonacci($n) = fibonacci(${n - 1}) + fibonacci(${n - 2})")
    verboseFibonacci(n - 1, tabs + 1) + verboseFibonacci(n - 2, tabs + 1)
}

verboseFibonacci(6)