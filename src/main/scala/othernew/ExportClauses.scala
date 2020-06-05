package othernew

import util.{AppWithPrint, Comment, Fact}

object ExportClauses extends AppWithPrint("Export Clauses") {
  class BitMap
  class InkJet

  class Printer {
    type PrinterType
    def print(bits: BitMap): Unit = ???
    def status: List[String] = ???
  }

  class Scanner {
    def scan(): BitMap = ???
    def status: List[String] = ???
  }

  class Copier {
    private val printUnit = new Printer { type PrinterType = InkJet }
    private val scanUnit = new Scanner

    export scanUnit.scan
    export printUnit.{status => _, _}

//  above code will define the following export aliases in Copier class
//  final def scan(): BitMap            = scanUnit.scan()
//  final def print(bits: BitMap): Unit = printUnit.print(bits)
//  final type PrinterType              = printUnit.PrinterType

    def status: List[String] = printUnit.status ++ scanUnit.status
  }

  val defineExportClauses =
    Fact("define export clauses")

  override def results = List(defineExportClauses)
}
