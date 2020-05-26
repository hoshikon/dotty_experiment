package util

import scala.util.Try

case class Attempt(result: Try[Boolean], comment: String)

object Attempt {
  def apply(result: => Boolean, comment: String): Attempt = Attempt(Try(result), comment)
}
