



val myList: List[Int] = (1 to 5).toList 

def sumElements(list: List[Int]): Int = 
  if (list.isEmpty) 0
  else list.head + sumElements(list.tail)

sumElements(myList)