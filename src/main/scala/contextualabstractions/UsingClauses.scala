package contextualabstractions

import util.{AppWithPrint, Assert}
import GivenInstances.{Ord, intOrd}

object UsingClauses extends AppWithPrint("Using Clauses") {
  
  def max[T](t1: T, t2: T)(using ord: Ord[T]): T =
    if ord.compare(t1, t2) < 0 then t2 else t1

  val defineFunctionWithContextParameter =
    Assert(
      "define function with context parameter",
      max(List(1,2,3), List(1,2,3,4)) == List(1,2,3,4)
    )

  def maximum[T](ts: List[T])(using Ord[T]): T = ts.reduce(max)

  val defineFunctionWithAnonymousContextParameter =
    Assert(
      "define function with anonymous context parameter",
      maximum(List(1,9,2,8,3,7,4,6,5)) == 9
    )

  val summoned = summon[Ord[Int]]

  val summonGivenInstance =
    Assert(
      "summon a given instance",
      intOrd == summoned
    )

  override val results = List(
    defineFunctionWithContextParameter,
    defineFunctionWithAnonymousContextParameter,
    summonGivenInstance
  )
}
