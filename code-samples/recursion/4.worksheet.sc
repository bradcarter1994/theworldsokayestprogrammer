val myList = List(10)

def sumElements(list: List[Int]): Int = list match {
  case List(exactly1Element) => exactly1Element
}

sumElements(myList)