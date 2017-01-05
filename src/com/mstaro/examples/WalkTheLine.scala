package com.mstaro.examples

/**
  * Created by mstaro on 1/5/17.
  */
object WalkTheLine {
  type Birds = Int

  case class SecondPole(left: Birds, right: Birds) {
    def landLeft(n: Birds): Either[String, SecondPole] =
      if (math.abs((left + n) - right) < 4) Right(copy(left = left + n))
      else Left("Can't put birds on the left side of the pole: Difference with right side higher than 4.")
    def landRight(n: Birds): Either[String, SecondPole] =
      if (math.abs(left - (right + n)) < 4) Right(copy(right = right + n))
      else Left("Can't put birds on the right side of the pole: Difference with left side higher than 4.")
  }

  def main(args: Array[String]): Unit = {
    val secondPole = SecondPole(0,0).landLeft(3).fold(l => {println(l)},r => {r})
    println(secondPole)
  }
}
