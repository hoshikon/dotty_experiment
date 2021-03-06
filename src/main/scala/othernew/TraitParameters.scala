package othernew

import util.{AppWithPrint, Assert}

object TraitParameters extends AppWithPrint("Trait Parameters") {

  trait Greeting(val name: String) {
    def msg = s"How are you, $name"
  }

  trait FormalGreeting extends Greeting {
    override def msg = s"How do you do, $name"
  }

  // you MUST extends both Greeting and FormalGreeting here
  class GreetingToBob(val bobWho: String) extends Greeting(s"Bob $bobWho") with FormalGreeting

  val defineATraitWithParameter =
    Assert(
      "define a trait with parameter",
      new GreetingToBob("Marley").msg == "How do you do, Bob Marley"
  )

  override def results = List(defineATraitWithParameter)
}
