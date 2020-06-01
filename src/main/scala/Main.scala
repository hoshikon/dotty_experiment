import enums._
import newtypes._
import contextualabstractions._

object Main {
  def main(args: Array[String]): Unit = {
    List(
      // new types
      IntersectionType,
      UnionType,
      TypeLambdas,
      MatchType,
      DependentFunctionType,

      // enums
      Enums,
      EnumsADT,

      // contextual abstractions
      GivenInstances,
      UsingClauses,
      ContextBounds
    ).foreach(_.print())
  }
}
