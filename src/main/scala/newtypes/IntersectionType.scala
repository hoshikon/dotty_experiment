package newtypes

import util.{AppWithPrint, Attempt}

object IntersectionType extends AppWithPrint("Intersection Type") {

  trait A
  trait B
  type AANDB = A & B
  type BANDA = B & A
  object C extends A with B

  val isAnIntersection =
    Attempt(
      C.isInstanceOf[AANDB],
      "define an intersection type of two types"
    )

  val isCommutative =
    Attempt(
      C.isInstanceOf[BANDA],
      "respect commutativity law"
    )

  override def results = List(isAnIntersection, isCommutative)
}
