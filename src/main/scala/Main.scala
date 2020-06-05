import enums._
import newtypes._
import contextualabstractions._
import othernew._

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
      ContextBounds,

      // other new features
      TraitParameters,
      CreatorApplications,
      ExportClauses
    ).foreach(_.print())
  }
}
