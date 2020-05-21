package newstuff.types

import util.AppWithPrint

object TypeLambdas extends AppWithPrint("Type Lambdas") {
  case class Wrapper[T](value: T)
  type WrapperLambda = [T] =>> Wrapper[T]

  val wrapped = Wrapper("wrapped")

  val canDefineTypeLambda =
    Either.cond(
      wrapped.isInstanceOf[WrapperLambda[String]] && wrapped.isInstanceOf[Wrapper[String]],
      "can define type lambdas",
      "can NOT define type lambdas"
    )

  override def results: List[Either[String, String]] = List(canDefineTypeLambda)
}
