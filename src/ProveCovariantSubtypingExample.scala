object ProveCovariantSubtypingExample {

  // Some normal class
  case class FooNormal[A](a: A)

  // False: FooNormal[Quux] <:< FooNormal[Bar]

  // Hierarchy
  trait Bar

  case class Baz(i: Int) extends Bar

  case class Quux(n: String) extends Bar

  def funcNormal[A <: Bar](f: FooNormal[A]) = "ho"

  val bar = Quux("foo")
  val fooNorm = FooNormal(bar)

  // Expected FooNormal[Bar], got FooNormal[Quux]
  funcNormal(fooNorm)

  // Covariant class
  case class FooCov[+A](a: A)

  // True: FooCov[Quux] <:< FooCov[Bar]

  def funcCov(f: FooCov[Bar]) = "ba"

  val fooCov: FooCov[Quux] = FooCov(bar)

  funcCov(fooCov)

  class Shoe

  def prove[T](implicit ev: T = null) = ev != null

  def main(args: Array[String]) {
    println(prove[FooNormal[Quux] <:< FooNormal[Bar]])

    println(prove[FooCov[Quux] <:< FooCov[Bar]])

    println(prove[List[Int] <:< List[String]])

    println(prove[List[Int] <:< List[AnyRef]])

    println(prove[List[Int] <:< List[Any]])

    println(prove[List[Int] <:< List[AnyVal]])

    println(prove[List[String] <:< List[AnyRef]])

    println(prove[Shoe <:< AnyRef])
  }
}
