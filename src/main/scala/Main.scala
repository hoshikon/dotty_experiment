import newstuff.types._

object Main {
  def main(args: Array[String]): Unit = {
    List(
      IntersectionType,
      UnionType,
      TypeLambdas,
      MatchType,
      DependentFunctionType
    ).foreach(_.print())
  }
}
