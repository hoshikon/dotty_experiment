package othernew

import util.{AppWithPrint, Fact}

object OpenClasses extends AppWithPrint("Open Classes") {

  open class Writer[T] {
    def send(x: T): Unit = println(x)
  }

  // classes that are not open can still be extended but will issue a warning unless:
  //  - the extending class is in the same source file
  //  - language feature adhocExtensions is enabled by
  //    - import scala.language.adhocExtensions
  //    - commandline option '-language:adhocExtensions'

  val defineOpenClass = Fact("define open class")

  override def results = List(defineOpenClass)
}
