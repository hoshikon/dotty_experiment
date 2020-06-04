package newtypes

import util.{AppWithPrint, Attempt}

object UnionType extends AppWithPrint("Union Type") {

  trait A
  trait B
  type AorB = A | B
  type BorA = B | A
  object C extends A
  object D extends B

  def aOrBToString(aOrB: AorB): String = aOrB match {
    case _: A => "A"
    case _: B => "B"
  }

  val isAUnion =
    Attempt("define a union type of two types") {
      C.asInstanceOf[AorB]
      D.asInstanceOf[AorB]
    }

  val isCommutative =
    Attempt("respect commutativity law") {
      C.asInstanceOf[BorA];
      D.asInstanceOf[BorA];
    }

  override def results = List(isAUnion, isCommutative)
}
