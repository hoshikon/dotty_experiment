package newstuff.types

import util.AppWithPrint

object IntersectionType extends AppWithPrint("Intersection Type") {

  trait A
  trait B
  type AANDB = A & B
  type BANDA = B & A
  object C extends A with B

  val isAnIntersection =
    Either.cond(
      C.isInstanceOf[AANDB],
      "can define an intersection type of two types",
      "can NOT define an intersection type of two types"
    )

  val isCommutative =
    Either.cond(
      C.isInstanceOf[BANDA],
      "is commutative",
      "is NOT commutative"
    )

  override def results = List(isAnIntersection, isCommutative)
}
