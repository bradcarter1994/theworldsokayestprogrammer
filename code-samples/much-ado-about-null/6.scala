def reverseString(str: String): String = {
  if (str == null) throw IllegalArgumentException("Parameter str was null")
  str.reverse
}

println(reverseString("racecar"))