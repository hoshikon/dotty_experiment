package othernew

import util.{AppWithPrint, Fact}

object SafeInitialization extends AppWithPrint("Safe Initialization") {

//  Dotty implements a safe initialization check which can be enabled by '-Ycheck-init'

//  abstract class AbstractFile {
//     def name: String
//     val extension: String = name.split('.').last
//  }
//
//  class RemoteFile(url: String) extends AbstractFile {
//     val localFile: String = url.hashCode + ".tmp"
//     def name: String = localFile
//  }
//
//  The checker will report:

//  Access non-initialized field localFile. Calling trace:
//   -> val extension: String = name.split('.').last    [ SafeInitialization.scala:11 ]
//    -> def name: String = localFile   [ SafeInitialization.scala:16 ]


  val enableSafeInitialization = Fact("enable safe initialization")

  override def results = List(enableSafeInitialization)

}
