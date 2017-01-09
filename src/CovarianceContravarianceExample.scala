/**
  * Created by mstaro on 1/9/17.
  */
object CovarianceContravarianceExample {

  class Animal {}

  class Mammal extends Animal {}

  class Dog extends Mammal {
    override def toString: String = "I am a dog!"
  }

  class Cat extends Mammal {
    override def toString: String = "I am a cat!"
  }

  class Box1[+T] {}

  class Box2[-T]{}

  class Box3[T]{}

  def method1(box : Box1[Mammal]) {}

  def method2(box : Box2[Mammal]) {}

  def method3(box : Box3[Mammal]) {}

  def main(args: Array[String]): Unit = {

    /**
      * Covariant
      */
    method1(new Box1[Mammal])
    method1(new Box1[Dog])
//        method1(new Box1[Animal]) // compile fails

    /**
      * Contravariant
      */
    method2(new Box2[Animal])
    method2(new Box2[Mammal])
    //    method2(new Box2[Dog]) // compile fails

    /**
      * Invariant
      */
    method3(new Box3[Mammal])
    //    method3(new Box3[Dog]) // compile fails
    //    method3(new Box3[Animal]) // compile fails
 }
}
