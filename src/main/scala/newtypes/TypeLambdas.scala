package newtypes

import util.{AppWithPrint, Attempt}

object TypeLambdas extends AppWithPrint("Type Lambdas") {
  case class Wrapper[T](value: T)
  type WrapperLambda = [T] =>> Wrapper[T]

  val wrapped = Wrapper("wrapped")

  val canDefineTypeLambda =
    Attempt("define type lambdas") {
      wrapped.asInstanceOf[WrapperLambda[String]]
      wrapped.asInstanceOf[Wrapper[String]]
    }

  override def results = List(canDefineTypeLambda)
}
