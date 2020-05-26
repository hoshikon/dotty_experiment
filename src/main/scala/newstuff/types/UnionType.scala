package newstuff.types

import util.{AppWithPrint, Attempt}

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
    Attempt(
      C.isInstanceOf[AORB],
      "define a union type of two types"
    )

  val isCommutative =
    Attempt(
      C.isInstanceOf[BORA],
      "respect commutativity law"
    )

  override def results = List(isAUnion, isCommutative)
}