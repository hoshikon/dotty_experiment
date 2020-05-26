package newstuff.types

import util.{AppWithPrint, Attempt}

import scala.Eql
import scala.annotation.tailrec

object MatchType extends  AppWithPrint("Match Type") {

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
    Attempt(
      headOfString == 'S' && headOfArray == 1 && headOfList == List(1),
      "reduce multiple types into one type"
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

  val firstLeafOfNestedList = firstLeafOf(nestedList(10000)("String"))

  given Eql[Any, Any] = Eql.eqlAny //disable strict equality
  val canRecursivelyReduceMultipleTypesIntoASingleType =
    Attempt(
      firstLeafOfNestedList == 'S',
      "recursively reduce multiple types into one type"
    )

  override def results =
    List(
      canReduceMultipleTypesIntoASingleType,
      canRecursivelyReduceMultipleTypesIntoASingleType
    )
}
