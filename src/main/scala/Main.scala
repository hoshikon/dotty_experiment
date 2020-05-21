import newstuff.types._

object Main {
  def main(args: Array[String]): Unit = {
    List(
      Intersection,
      Union,
      TypeLambdas
    ).foreach(_.print())
  }
}
