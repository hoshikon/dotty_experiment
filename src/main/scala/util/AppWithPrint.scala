package util

trait AppWithPrint(val title: String) extends App {
  def results: List[Either[String, String]]

  def print(printer: String => Unit = scala.Predef.print): Unit = {
    printer(s"[$title]\n")
    results.map(r => "- " + toColoredString(r) + "\n").foreach(printer)
    printer("\n")
  }

  private def toColoredString(either: Either[String, String]): String =
    either match {
      case Right(str) => Console.GREEN + str + Console.RESET
      case Left(str) => Console.RED + str + Console.RESET
    }
}
