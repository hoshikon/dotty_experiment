package newstuff.enums

import util.{AppWithPrint, Attempt}

import math.Ordered.orderingToOrdered
import math.Ordering.Implicits.infixOrderingOps

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
    Attempt(
      blue.isInstanceOf[Color.Blue.type],
      "define enums"
    )

  val canDefineParametrizedEnum =
    Attempt(
      greenHex.hex == 0x00FF00,
      "define parametrized enum"
    )

  val canCompareEnumsByOrdinal =
    Attempt(
      ColorJava.Red.ordinal == 0 && ColorJava.Green.compareTo(ColorJava.Blue) == -1,
      "compare enums by ordinal"
    )

  val canGetValues =
    Attempt(
      Color.valueOf("Red") == Color.Red &&
        Color.values.sameElements(Array(Color.Red, Color.Green, Color.Blue)),
      "get values"
    )

  override def results = List(
    canDefineEnum,
    canDefineParametrizedEnum,
    canCompareEnumsByOrdinal,
    canGetValues
  )
}
