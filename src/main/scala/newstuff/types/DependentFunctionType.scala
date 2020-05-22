package newstuff.types

import util.AppWithPrint

object DependentFunctionType extends AppWithPrint("Dependent Function Type") {

  trait HasKey { type Key; val key: Key }

  def extractKey(hk: HasKey): hk.Key = hk.key

  type KeyExtractor = (hk: HasKey) => hk.Key //this does not compile in scala 2
  val canDefineDependentFunctionType =
    Either.cond(
      (extractKey _).isInstanceOf[KeyExtractor],
      "can define a function value with dependent type",
      "can NOT define a function value with dependent type"
    )

  override def results: List[Either[String, String]] = List(canDefineDependentFunctionType)
}
