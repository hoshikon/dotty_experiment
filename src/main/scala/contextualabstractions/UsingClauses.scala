package contextualabstractions

import util.{AppWithPrint, Attempt}
import GivenInstances.{Ord, intOrd}

object UsingClauses extends AppWithPrint("Using Clauses") {
  
  def max[T](t1: T, t2: T)(using ord: Ord[T]): T =
    if ord.compare(t1, t2) < 0 then t2 else t1

  val defineFunctionWithContextParameter =
    Attempt(
      max(List(1,2,3), List(1,2,3,4)) == List(1,2,3,4),
      "define function with context parameter"
    )

  def maximum[T](ts: List[T])(using Ord[T]): T = ts.reduce(max)

  val defineFunctionWithAnonymousContextParameter =
    Attempt(
      maximum(List(1,9,2,8,3,7,4,6,5)) == 9,
      "define function with anonymous context parameter"
    )

  val summoned = summon[Ord[Int]]

  val summonGivenInstance =
    Attempt(
      intOrd == summoned,
      "summon a given instance"
    )

  override val results = List(
    defineFunctionWithContextParameter,
    defineFunctionWithAnonymousContextParameter,
    summonGivenInstance
  )
}
