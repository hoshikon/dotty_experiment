package newstuff.types

import util.AppWithPrint

object Union extends AppWithPrint("Union") {

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
      "C is a union of A and B",
      "C is NOT a union of A and B"
    )

  val isCommutative =
    Either.cond(
      C.isInstanceOf[BORA],
      "'|' is commutative",
      "'|' is NOT commutative"
    )

  override def results = List(isAUnion, isCommutative)
}