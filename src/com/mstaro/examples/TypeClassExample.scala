package com.mstaro.examples

/**
  * Created by mstaro on 4/20/17.
  */
object TypeClassExample {
  object encode {
    trait MagicEncoder[A, B]{
      def apply(e: A): B
    }

    def apply[A, B](e: A)(implicit encoder: MagicEncoder[A, B]): B =
      encoder(e)

    implicit val encodeIntList = new MagicEncoder[List[Int], String] {
      override def apply(l: List[Int]): String =
        l.foldLeft("") { (acc, n) =>
          if (acc.isEmpty)
            n.toString
          else
            s"$acc,$n"
        }
    }

    implicit val encodeFloatList = new MagicEncoder[List[Float], String] {
      override def apply(l: List[Float]): String =
        l.foldLeft(0.toFloat) { (acc, n) =>
          acc + n
        }.toString
    }

    implicit val encodeInt = new MagicEncoder[Int, String] {
      override def apply(e: Int): String =
        e.toString
    }

    implicit val encodeFloat = new MagicEncoder[Float, String] {
      override def apply(e: Float): String =
        e.toString
    }

    implicit val encodeString = new MagicEncoder[String, String] {
      override def apply(s: String): String =
        s.toUpperCase()
    }

    implicit val encodeStringList = new MagicEncoder[List[String], List[Int]] {
      override def apply(strList: List[String]): List[Int] =
        strList.map(_.hashCode)
    }
  }

  def main(args: Array[String]): Unit = {
    println(encode(List(1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5).mkString(","))

    println(encode(List(0.5f, 2.4f, 5.6f)) == "8.5")

    println(encode(5) == "5")

    println(encode(5.5f) == "5.5")

    println(encode("foo") == "FOO")

    println(encode(List("foo", "bar", "baz", "bat")))
  }
}
