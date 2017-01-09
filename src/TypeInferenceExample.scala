/**
  * Created by mstaro on 1/9/17.
  */
object TypeInferenceExample {
  def main(args: Array[String]): Unit = {
    // list of integer
    val intsList = List(1,2,3,4,5)

    // list of any
    val anyList = "foo" :: intsList

    println(anyList)
  }
}
