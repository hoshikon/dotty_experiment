package contextualabstractions

import util.{AppWithPrint, Attempt}
import GivenInstances.Ord
import UsingClauses.max

object ContextBounds extends AppWithPrint("Context Bounds") {

  def maximum[T: Ord](ts: List[T]): T = ts.reduce(max)

  val useContextBound =
    Attempt(
      maximum(List(3,5,4)) == 5,
      "use context bound"
    )
  
  override def results = List(useContextBound)
}
