package contextualabstractions

import util.{AppWithPrint, Assert}

import scala.language.implicitConversions
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}
import java.util.concurrent.ForkJoinPool

object GivenInstances extends AppWithPrint("Given Instances") {

  trait Ord[T] {
    def compare(t1: T, t2: T): Int
    def (t1: T) < (t2: T) = compare(t1, t2) < 0
    def (t1: T) > (t2: T) = compare(t1, t2) > 0
  }

  given intOrd as Ord[Int] {
    def compare(n1: Int, n2: Int): Int =
      if (n1 < n2) -1 else if (n1 > n2) 1 else 0
  }

  given listOrd[T](using ord: Ord[T]) as Ord[List[T]] {
    def compare(l1: List[T], l2: List[T]): Int = (l1, l2) match {
      case (Nil, Nil) => 0
      case (Nil, _) => -1
      case (_, Nil) => +1
      case (x :: xs1, y :: ys1) =>
        val fst = ord.compare(x, y)
        if (fst != 0) fst else compare(xs1, ys1)
    }
  }

  def compareList[T](l1: List[T], l2: List[T])(using ord: Ord[List[T]]) = {
    ord.compare(l1, l2)
  }

  lazy val defineGivenInstance =
    Assert(
      "define given instance",
      compareList(List(1,2,3), List(1,2,3,4)) == -1
    )

  given Ord[String] {
    def compare(t1: String, t2: String): Int = t1.compare(t2)
  }

  given [T](using Ord[T]) as Ord[Vector[T]] {
    def compare(v1: Vector[T], v2: Vector[T]): Int = listOrd.compare(v1.toList, v2.toList)
  }

  def compareVector[T](v1: Vector[T], v2: Vector[T])(using ord: Ord[Vector[T]]) = {
    ord.compare(v1, v2)
  }

  lazy val defineAnonymousGivenInstance =
    Assert(
      "define given instance without a name",
      compareVector(Vector(1,2,3), Vector(1,2,3,4)) == -1
    )

  given global as ExecutionContext =  ExecutionContext.fromExecutorService(new ForkJoinPool())

  lazy val defineAliasGivenInstance =
    Assert(
      "define alias given instance",
      Await.result(Future.apply("hey"), 1.second) == "hey"
  )

  override def results = List(
    defineGivenInstance,
    defineAnonymousGivenInstance,
    defineAliasGivenInstance
  )
}
