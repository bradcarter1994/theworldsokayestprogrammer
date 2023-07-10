val cache = new scala.collection.mutable.HashMap[Int, Int]()

def memoizedFibonacci(n: Int): Int =
  if (cache.contains(n)) cache(n)
  else {
    val result = n match {
      case 0 | 1 => 1
      case n => memoizedFibonacci(n - 1) + memoizedFibonacci(n - 2)
    }
    cache(n) = result
    result
  }

memoizedFibonacci(6)