package newstuff.types

import util.AppWithPrint

object UnionType extends AppWithPrint("Union Type") {

  trait A
  trait B
  type AORB = A | B
  type BORA = B | A
  object C extends A
  object D extends B

  def aOrBToString(aOrB: AORB): String = aOrB match {
    case _: A => "A"
    case _: B => "B"
  }

  val isAUnion =
    Either.cond(
      C.isInstanceOf[AORB],
      "can define a union type of two types",
      "can NOT define a union type of two types"
    )

  val isCommutative =
    Either.cond(
      C.isInstanceOf[BORA],
      "is commutative",
      "is NOT commutative"
    )

  override def results = List(isAUnion, isCommutative)
}