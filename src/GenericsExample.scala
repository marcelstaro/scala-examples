/**
  * Created by mstaro on 1/9/17.
  */
object GenericsExample {

  class LinkedList[A] {
    private var head: Node[A] = _

    private class Node[A](elem: A) {
      var next: Node[A] = _

      override def toString: String = elem.toString
    }

    def add(elem: A) {
      val n = new Node(elem)
      n.next = head
      head = n
    }

    private def printNodes(n: Node[A]) {
      if (n != null) {
        println(n)

        printNodes(n.next)
      }
    }

    def printAll() {
      printNodes(head)
    }
  }

  def main(args: Array[String]): Unit = {
    val list = new LinkedList[Int]()
    list.add(5)
    list.add(6)
    list.add(7)


    val list2 = new LinkedList[String]()
    list2.add("foo")
    list2.add("bar")
    list2.add("quux")

    list.printAll()

    list2.printAll()
  }
}
