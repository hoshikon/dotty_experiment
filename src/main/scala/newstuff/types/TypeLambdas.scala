package newstuff.types

import util.{AppWithPrint, Attempt}

object TypeLambdas extends AppWithPrint("Type Lambdas") {
  case class Wrapper[T](value: T)
  type WrapperLambda = [T] =>> Wrapper[T]

  val wrapped = Wrapper("wrapped")

  val canDefineTypeLambda =
    Attempt(
      wrapped.isInstanceOf[WrapperLambda[String]] && wrapped.isInstanceOf[Wrapper[String]],
      "define type lambdas"
    )

  override def results = List(canDefineTypeLambda)
}
