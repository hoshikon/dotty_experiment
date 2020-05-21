package newstuff.types

import util.AppWithPrint

import scala.Eql
import scala.annotation.tailrec

object Match extends  AppWithPrint("Union") {

  type Elem[T] = T match {
    case String => Char
    case Array[t] => t
    case Iterable[t] => t
  }

  def headOf[T](t: T): Elem[T] = t match {
    case s: String => s.charAt(0)
    case arr: Array[t] => arr(0)
    case it: Iterable[t] => it.head
  }

  val headOfString = headOf("String")
  val headOfArray = headOf(Array(1, 2, 3))
  val headOfList = headOf(List(List(1), List(2), List(3)))

  val canReduceMultipleTypesIntoASingleType =
    Either.cond(
      headOfString == 'S' && headOfArray == 1 && headOfList == List(1),
      "can reduce multiple types into one type",
      "can NOT reduce multiple types into one type"
    )


  type LeafElem[T] = T match {
    case String => Char
    case Array[t] => LeafElem[t]
    case Iterable[t] => LeafElem[t]
    case Any => T
  }

  @tailrec
  def firstLeafOf[T](t: T): LeafElem[T] = t match {
    case s: String => s.charAt(0)
    case arr: Array[t] => firstLeafOf(arr(0))
    case it: Iterable[t] => firstLeafOf(it.head)
    case a: Any => a
  }

  @tailrec
  def nestedList[T](level: Int)(leaf: T): Any = {
    if (level == 0) leaf
    else nestedList(level - 1)(List(leaf))
  }

  val firstLeafOfNestedList = firstLeafOf(nestedList(100)("String"))

  given Eql[Any, Any] = Eql.eqlAny //disable strict equality
  val canRecursivelyReduceMultipleTypesIntoASingleType =
    Either.cond(
      firstLeafOfNestedList == 'S',
      "can recursively reduce multiple types into one type",
      "can NOT recursively reduce multiple types into one type"
    )

  override def results: List[Either[String, String]] =
    List(
      canReduceMultipleTypesIntoASingleType,
      canRecursivelyReduceMultipleTypesIntoASingleType
    )
}
