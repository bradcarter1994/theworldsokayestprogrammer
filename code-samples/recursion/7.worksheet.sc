val myList: List[Int] = (1 to 5).toList 

def sumElements(list: List[Int]): Int = list match {
  case List() => 0
  case List(exactly1Element) => exactly1Element
  case head :: tail => head + sumElements(tail)
}

sumElements(myList)