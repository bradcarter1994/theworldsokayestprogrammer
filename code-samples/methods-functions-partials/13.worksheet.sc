case class Customer(name: String, age: Int)

val customerCache = Map(
  1 -> Customer("John", 21),
  2 -> Customer("Jane", 22),
  3 -> Customer("Jeff", 23)
)

def getCustomerById(id: Int): Option[Customer] = customerCache.get(id)

List(7, 2, 8, 3) collect Function.unlift(getCustomerById)