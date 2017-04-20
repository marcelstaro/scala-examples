package com.mstaro.examples

import scalaz._
import Scalaz._

/**
  * Created by mstaro on 4/20/17.
  */
object ApplicativeExample {

  case class Failure(s: String)

  object Failure {
    implicit val semiGroup = new Semigroup[Failure] {
      override def append(f1: Failure, f2: => Failure): Failure = {
        Failure(s"${f1.s}; ${f2.s}")
      }
    }
  }

  def validate(n: Int): Validation[Failure, Int] =
    if ((n % 10) == 0) n.success else Failure("Not multiple of 10").failure

  def main(args: Array[String]): Unit = {
    println(validate(10) |+| validate(5) |+| validate(25))
  }
}
