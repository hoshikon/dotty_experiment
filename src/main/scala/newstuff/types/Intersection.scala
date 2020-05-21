package newstuff.types

import util.AppWithPrint

object Intersection extends AppWithPrint("Intersection") {

  trait A
  trait B
  type AANDB = A & B
  type BANDA = B & A
  object C extends A with B

  val isAnIntersection =
    Either.cond(
      C.isInstanceOf[AANDB],
      "C is an intersection of A and B",
      "C is NOT an intersection of A and B"
    )

  val isCommutative =
    Either.cond(
      C.isInstanceOf[BANDA],
      "'&' is commutative",
      "'&' is NOT commutative"
    )

  override def results = List(isAnIntersection, isCommutative)
}
