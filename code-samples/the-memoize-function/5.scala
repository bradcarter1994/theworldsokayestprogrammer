def memoize[I, O](f: I => O): I => O = new scala.collection.mutable.HashMap[I, O]() {
	override def apply(key: I) = getOrElseUpdate(key, f(key))
}

val fibonacci: Int => Int = memoize {
  case 0 | 1 => 1
  case n => fibonacci(n - 1) + fibonacci(n - 2)
}

fibonacci(6)