package util

import scala.util.Success

trait AppWithPrint(val title: String) extends App {
  def results: List[Attempt]

  def print(printer: String => Unit = scala.Predef.print): Unit = {
    printer(s"[$title]\n")
    results.map(r => "- " + toColoredString(r) + "\n").foreach(printer)
    printer("\n")
  }

  private def toColoredString(attempt: Attempt): String =
    attempt.result match {
      case Success(true) => Console.GREEN + attempt.comment + Console.RESET
      case _ => Console.RED + s"failed to ${attempt.comment}" + Console.RESET
    }
}
