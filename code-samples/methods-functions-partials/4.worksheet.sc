val doubleIt = new Function1[Int, Int] {
  def apply(x: Int): Int = {
    x * 2
  }
} 

doubleIt.apply(4)