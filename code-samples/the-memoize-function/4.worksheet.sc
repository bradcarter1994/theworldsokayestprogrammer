val cache = new scala.collection.mutable.HashMap[Int, Int]()

def verboseMemoizedFibonacci(n: Int, tabs: Int = 0): Int =
  if (cache.contains(n))
    println("  " * tabs + s"Cache Hit: fibonacci($n) = ${cache(n)}")
    cache(n)
  else {
    val result = n match {
      case 0 | 1 =>
        println("  " * tabs + s"Cache Miss: fibonacci($n) = 1")
        1
      case n =>
        println("  " * tabs + s"Cache Miss: fibonacci($n) = fibonacci(${n - 1}) + fibonacci(${n - 2})")
        verboseMemoizedFibonacci(n - 1, tabs + 1) + verboseMemoizedFibonacci(n - 2, tabs + 1)
    }
    cache(n) = result
    result
  }

verboseMemoizedFibonacci(6)