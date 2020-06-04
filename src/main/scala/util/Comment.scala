package util

import scala.util.Try

sealed trait Comment { val text: String }

case class Fact(text: String) extends Comment
case class Assert(text: String, result: Boolean) extends Comment
case class Attempt(text: String, result: Try[Unit]) extends Comment
object  Attempt {
  def apply(text: String)(result: => Unit): Attempt = Attempt(text, Try(result))
}
case class AttemptAssert(text: String, result: Try[Boolean]) extends Comment
object AttemptAssert {
  def apply(text: String)(result: => Boolean): AttemptAssert = AttemptAssert(text, Try(result))
}

