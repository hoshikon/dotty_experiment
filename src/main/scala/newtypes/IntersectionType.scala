package newtypes

import util.{AppWithPrint, Attempt}

object IntersectionType extends AppWithPrint("Intersection Type") {

  trait A
  trait B
  type AandB = A & B
  type BandA = B & A
  object C extends A with B

  val isAnIntersection =
    Attempt("define an intersection type of two types")(C.asInstanceOf[AandB])

  val isCommutative =
    Attempt("respect commutativity law")(C.asInstanceOf[BandA])

  override def results = List(isAnIntersection, isCommutative)
}
