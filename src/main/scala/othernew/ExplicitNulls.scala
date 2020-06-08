package othernew

import util.{AppWithPrint, Fact}

object ExplicitNulls extends AppWithPrint("Explicit Nulls") {

//  When explicit nulls are enabled via `-Yexplicit-nulls`,
//  the type hierarchy changes so that Null is only a subtype of Any as opposed to every reference type.
//  (reference: src/main/resources/explicit-nulls-type-hierarchy.png)

//  Hence this will not compile:
//  val x: String = null

  val x: String|Null = null

  val enableExplicitNulls = Fact("enable explicit nulls")

// This will cause unsoundness in following case:

//  class C {
//    val f: String = foo(f)
//    def foo(f2: String): String = f2
//  }
//  val c = new C()

// This can be caught by the compiler with `-Ycheck-init` option
  val catchInitializationIssue = Fact("catch initialization issue using '-Ycheck-init' option")

// The following comparison is not allowed anymore unless it is nullable union type or casted
//  val x: String = "a"
//  x == null

  val y: String | Null = "1"
  y == null
  (x: String | Null) == null
  (x: Any) == null

  val disallowNonNullAndNullComparison = Fact("disallow comparison between Null and non-Null values")

// cast away null
  y.nn.toInt

// Java code will be patched
//  class C {
//    String s;
//    final int i;
//    @NotNull String s2;
//  }
//
//  will become
//
//  class C {
//    val s: String | UncheckedNull
//    val i: Int
//    val s2: String
//  }
  val javaInterop = Fact("convert type 'T' in java code to 'T | UncheckedNull'")

//Flow Typing
  val s: String | Null = ""

  if (s != null) {
    //s: String
  } else if (s != null && s.length > 0) { // s: String in `s.length > 0`
    //s: String | Null
  }

  s match {
    case _: String => //s: String
    case _ => //s: String | Null
  }

  var s2: String | Null = ""
  def f = {
    s2 = null
  }
  if (s2 != null) {
    // f can be called here, which break the fact
    //val a: String = s2    this will be error: x is captured and mutated by the closure, not trackable
  }

  val hasFlowTyping = Fact("use flow typing")

  override def results =
    List(
      enableExplicitNulls,
      catchInitializationIssue,
      disallowNonNullAndNullComparison,
      javaInterop,
      hasFlowTyping
    )
}
