package util

import scala.util.Success

trait AppWithPrint(val title: String) extends App {
  def results: List[Comment]

  def print(printer: String => Unit = scala.Predef.print): Unit = {
    printer(s"[$title]\n")
    results.map(r => "- " + toColoredString(r) + "\n").foreach(printer)
    printer("\n")
  }

  private def toColoredString(comment: Comment): String =
    comment match {
      case Fact(_) | Assert(_, true) | Attempt(_, Success(_)) | AttemptAssert(_, Success(true)) =>
        Console.GREEN + comment.text + Console.RESET
      case _ =>
        Console.RED + s"failed to ${comment.text}" + Console.RESET
    }
}
