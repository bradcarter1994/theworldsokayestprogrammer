def sumOf5Numbers(a: Int, b: Int, c: Int, d: Int, e: Int) = {
  a + b + c + d + e
}

sumOf5Numbers(1, 2, 3, 4, 5)

def longestOf3Strings(a: String, b: String, c: String) = {
  if (a.length() > b.length() && a.length() > c.length()) a
  else if (b.length() > c.length()) b
  else c
}

longestOf3Strings("Hello", "Hi", "How are you?")