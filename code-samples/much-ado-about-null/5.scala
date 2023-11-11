class Animal(val species: String) {
  def eat: Unit = println("munch munch munch")
}

case class Dog(name: String) extends Animal("Canis lupus familiaris") {
  def bark: Unit = println("Woof!")

  override def eat: Unit = {
    super.eat
    println("*wags tail*")
  }
}

val spot: Dog = Dog("Spot")
spot.eat