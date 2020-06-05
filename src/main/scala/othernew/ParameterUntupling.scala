package othernew

import util.{AppWithPrint, Comment, Fact}

object ParameterUntupling extends AppWithPrint("Parameter Untupling") {

  val listOfTuples: List[(Int, Int)] = List.empty

  listOfTuples.map { (x, y) => x + y }
  listOfTuples.map(_ + _)

  val convertFunctionsThatTakesTupleToPatternMatchingClosure =
    Fact("can omit 'case' word for function values that take tuples")

  override def results = List(convertFunctionsThatTakesTupleToPatternMatchingClosure)
}
