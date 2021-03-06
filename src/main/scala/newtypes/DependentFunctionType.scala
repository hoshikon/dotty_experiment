package newtypes

import util.{AppWithPrint, Attempt}

object DependentFunctionType extends AppWithPrint("Dependent Function Type") {

  trait HasKey { type Key; val key: Key }

  def extractKey(hk: HasKey): hk.Key = hk.key

  type KeyExtractor = (hk: HasKey) => hk.Key //this does not compile in scala 2
  val canDefineDependentFunctionType =
    Attempt("define a function value with dependent type"){
      (extractKey _).asInstanceOf[KeyExtractor]
    }

  override def results = List(canDefineDependentFunctionType)
}
