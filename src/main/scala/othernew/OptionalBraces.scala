package othernew

import util.{AppWithPrint, Fact}
import contextualabstractions.GivenInstances.Ord

object OptionalBraces extends AppWithPrint("Optional Braces") {
  trait A:
    def f: Int

  class C(x: Int) extends A:
    def f = x

  object O:
    def f = 3

  enum Color:
    case Red, Green, Blue

  type T = A

  given [T]: Ord[List[T]] = new Ord[List[T]]:
    def compare(x: List[T], y: List[T]) = ???

  extension (xs: List[Int])
    def second: Int = xs.tail.head

  val x =
    new A:
      def f = 3

  val y = (math.random() * 10).toInt


  //case clauses
  y match
  case 1 => "one"
  case 2 => "two"
  case 3 => "three"
  case _ => "many"

  //end marker
  abstract class D():
    def this(x: Int) =
      this()
      if x > 0 then
        val a :: b =
          x :: Nil
        end val
        var y =
          x
        end y
        while y > 0 do
          println(y)
          y -= 1
        end while
        try
          x match
            case 0 => println("0")
            case _ =>
          end match
        finally
          println("done")
        end try
      end if
    end this

    def f: String
  end D

  object D:
    given D =
      new D:
        def f = "!"
        end f
      end new
    end given
  end D

  extension (x: D)
    def ff: String = x.f ++ x.f
  end extension


  //another example
  enum IndentWidth:
    case Run(ch: Char, n: Int)
    case Conc(l: IndentWidth, r: Run)

    def <= (that: IndentWidth): Boolean = this match
      case Run(ch1, n1) =>
        that match
          case Run(ch2, n2) => n1 <= n2 && (ch1 == ch2 || n1 == 0)
          case Conc(l, r)   => this <= l
      case Conc(l1, r1) =>
        that match
          case Conc(l2, r2) => l1 == l2 && r1 <= r2
          case _            => false

    def < (that: IndentWidth): Boolean =
      this <= that && !(that <= this)

    override def toString: String = this match
      case Run(ch, n) =>
        val kind = ch match
          case ' '  => "space"
          case '\t' => "tab"
          case _    => s"'$ch'-character"
        val suffix = if n == 1 then "" else "s"
        s"$n $kind$suffix"
      case Conc(l, r) =>
        s"$l, $r"

  object IndentWidth:
    private inline val MaxCached = 40

    private val spaces = IArray.tabulate(MaxCached + 1)(new Run(' ', _))
    private val tabs = IArray.tabulate(MaxCached + 1)(new Run('\t', _))

    def Run(ch: Char, n: Int): Run =
      if n <= MaxCached && ch == ' ' then
        spaces(n)
      else if n <= MaxCached && ch == '\t' then
        tabs(n)
      else
        new Run(ch, n)
    end Run

    val Zero = Run(' ', 0)
  end IndentWidth

  val allowOptionalBraces =
    Fact("allow optional braces for well indented programs (significant indentation)")

  override def results = List(allowOptionalBraces)
}
