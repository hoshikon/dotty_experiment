package othernew

import util.{AppWithPrint, Fact}

import scala.annotation.threadUnsafe

object ThreadUnsafeAnnotation extends AppWithPrint("threadUnsafe annotation") {
  @threadUnsafe lazy val x = 1

  val useThreadUnsafeAnnotation =
    Fact("use @threadUnsafe annotation")

  override def results = List(useThreadUnsafeAnnotation)
}
