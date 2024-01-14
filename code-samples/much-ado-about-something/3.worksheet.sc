Option(1) 
Some(1)

Option(3.14) 
Some(3.14)

Option("Steve")
Some("Steve")

Option(true)
Some(true)

case class Foo(a: Int, b: String)
val myFoo = Foo(5, "Banana")
Option(myFoo) 
Some(myFoo)