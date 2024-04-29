val myList: List[Int] = Nil 

def sumElements(list: List[Int]): Int = list match {
  case List() => 0
  case List(exactly1Element) => exactly1Element
}

sumElements(myList)