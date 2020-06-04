package contextualabstractions

import contextualabstractions.GivenInstances.Ord
import contextualabstractions.UsingClauses.max
import util.{AppWithPrint, Assert}

object ContextBounds extends AppWithPrint("Context Bounds") {

  def maximum[T: Ord](ts: List[T]): T = ts.reduce(max)

  val useContextBound =
    Assert(
      "use context bound",
      maximum(List(3,5,4)) == 5
    )
  
  override def results = List(useContextBound)
}
