import newstuff.enums.Enums
import newstuff.types._

object Main {
  def main(args: Array[String]): Unit = {
    List(
      IntersectionType,
      UnionType,
      TypeLambdas,
      MatchType,
      DependentFunctionType,
      Enums
    ).foreach(_.print())
  }
}
