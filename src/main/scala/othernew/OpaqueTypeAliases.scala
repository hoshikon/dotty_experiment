package othernew

import util.{Assert, Attempt, AppWithPrint}

object OpaqueTypeAliases extends AppWithPrint("Opaque Type Aliases") {

  object Ids {
    opaque type Id = Int

    object Id {
      def apply(id: Int): Id = id
    }

    extension idOps on (id: Id) {
      def *(n: Int): Int = (id.toString * n).toInt
      def asString: String = s"[id: $id]"
    }

    val one = Id(1)

    val oneTimes3InsideScope = one * 3 == 3 // this '*' comes from Int's implementation
  }

  import Ids._

  class IdCard(val id: Id)
  val card = IdCard(Id(1))

  // These expression won't compile
  // one + 1
  // IdCard(1)

  val defineOpaqueTypeAliases =
    Assert(
      "define opaque type aliases",
      one.asString == "[id: 1]"
    )

  val oneTimes3OutsideScope = one * 3 == 111 // this '*' comes from Ids' implementation

  val correspondingTypeIsNotVisibleOutsideScope =
    Assert(
      "opaque type's corresponding type is only visible within the scope it was defined",
      oneTimes3InsideScope && oneTimes3OutsideScope
    )

  override def results = List(
    defineOpaqueTypeAliases,
    correspondingTypeIsNotVisibleOutsideScope
  )
}
