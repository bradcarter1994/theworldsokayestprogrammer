def verboseMemoize[I, O](f: I => O): I => O = new scala.collection.mutable.HashMap[I, O]() {
	override def apply(key: I) = {
    if (this.contains(key)) println(s"Cache Hit - Retrieving fibonacci($key) from cache")
    else println(s"Cache Miss - Calculating fibonacci($key) with unmemoizedVerboseFibonacci")
    getOrElseUpdate(key, f(key))
  }
}

def unmemoizedVerboseFibonacci(n: Int): Int = n match {
  case 0 | 1 => 
  	println(s"Base Case - fibonacci($n) = 1")
  	1
  case n => 
  	println(s"Recursive Case - fibonacci($n) = fibonacci(${n - 1}) + fibonacci(${n - 2})")
  	unmemoizedVerboseFibonacci(n - 1) + unmemoizedVerboseFibonacci(n - 2)
}

val verboseMemoizedFibonacci: Int => Int = verboseMemoize(unmemoizedVerboseFibonacci)

verboseMemoizedFibonacci(5)
println()
verboseMemoizedFibonacci(5)
println()
verboseMemoizedFibonacci(4)