package enums

import util.{AppWithPrint, Assert}

object EnumsADT extends AppWithPrint("Enums Algebraic Data Types") {

  enum Option[+T] {
    case Some(x: T) extends Option[T]
    case None extends Option[Nothing]

    def isDefined: Boolean = this match {
      case Some(_) => true
      case None => false
    }
  }

  object Option {
    def apply[T >: Null](x: T): Option[T] = if (x == null) None else Some(x)
  }

  val some = Option("hello")
  val none = Option.None

  val supportsADT =
    Assert(
      "support algebraic data types",
      some.isDefined && !none.isDefined
    )

  override def results = List(supportsADT)
}
