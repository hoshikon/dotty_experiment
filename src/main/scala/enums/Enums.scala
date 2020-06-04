package enums

import util.{AppWithPrint, Assert, Attempt}

object Enums extends AppWithPrint("Enums") {

  //this actually defines a new sealed class with 3 values Red, Green, Blue
  enum Color {
    case Red, Green, Blue
  }

  enum ColorHex(val hex: Int) {
    case Red   extends ColorHex(0xFF0000)
    case Green extends ColorHex(0x00FF00)
    case Blue  extends ColorHex(0x0000FF)
  }

  enum ColorJava extends java.lang.Enum[ColorJava]{
    case Red, Green, Blue
  }

  val blue = Color.Blue
  val greenHex = ColorHex.Green

  val canDefineEnum =
    Attempt("define enums")(blue.asInstanceOf[Color.Blue.type])

  val canDefineParametrizedEnum =
    Assert(
      "define parametrized enum",
      greenHex.hex == 0x00FF00
    )

  val canCompareEnumsByOrdinal =
    Assert(
      "compare enums by ordinal",
      ColorJava.Red.ordinal == 0 && ColorJava.Green.compareTo(ColorJava.Blue) == -1
    )

  val canGetValues =
    Assert(
      "get values",
      Color.valueOf("Red") == Color.Red &&
        Color.values.sameElements(Array(Color.Red, Color.Green, Color.Blue))
    )

  override def results = List(
    canDefineEnum,
    canDefineParametrizedEnum,
    canCompareEnumsByOrdinal,
    canGetValues
  )
}
