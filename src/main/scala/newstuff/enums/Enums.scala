package newstuff.enums

import util.AppWithPrint
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
    Either.cond(
      blue.isInstanceOf[Color.Blue.type],
      "can define enums",
      "can NOT define enums"
    )

  val canDefineParametrizedEnum =
    Either.cond(
      greenHex.hex == 0x00FF00,
      "can define parametrized enum",
      "can NOT define parametrized enum"
    )

  val canCompareEnumsByOrdinal =
    Either.cond(
      ColorJava.Red.ordinal == 0 && ColorJava.Green.compareTo(ColorJava.Blue) == -1,
      "can compare enums by ordinal",
      "can NOT compare enums by ordinal"
    )

  val canGetValues =
    Either.cond(
      Color.valueOf("Red") == Color.Red &&
        Color.values.sameElements(Array(Color.Red, Color.Green, Color.Blue)),
      "can get values",
      "can NOT get values"
    )

  override def results: List[Either[String, String]] = List(
    canDefineEnum,
    canDefineParametrizedEnum,
    canCompareEnumsByOrdinal,
    canGetValues
  )
}
