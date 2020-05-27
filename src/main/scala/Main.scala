import enums._
import newtypes._

object Main {
  def main(args: Array[String]): Unit = {
    List(
      // new types
      IntersectionType,
      UnionType,
      TypeLambdas,
      MatchType,
      DependentFunctionType,

      //enums
      Enums,
      EnumsADT
    ).foreach(_.print())
  }
}
