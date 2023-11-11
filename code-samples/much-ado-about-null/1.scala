class Animal(val species: String) {
  def eat: Unit = println("munch munch munch")
}

case class Dog(name: String) extends Animal("Canis lupus familiaris") {
  def bark: Unit = println("Woof!")
}

val spot: Dog = Dog("Spot")
spot.eat
spot.bark

val someAnimal: Animal = spot
someAnimal.eat
println(someAnimal.species)
// someAnimal.bark // Error: value bark is not a member of Playground.Animal