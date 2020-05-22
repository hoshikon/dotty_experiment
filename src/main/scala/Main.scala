import newstuff.types._

object Main {
  def main(args: Array[String]): Unit = {
    List(
      IntersectionType,
      UnionType,
      TypeLambdas,
      MatchType
    ).foreach(_.print())
  }
}
