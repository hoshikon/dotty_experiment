package othernew

import util.{AppWithPrint, Fact}

object NewControlSyntax extends AppWithPrint("New Control Syntax") {
  //quiet syntax
  var x = 10
  val xs = List(x)
  def f(n: Int) = n - 1

  if x < 0 then
    "negative"
  else if x == 0 then
    "zero"
  else
    "positive"

  if x < 0 then -x else x

  while x >= 0 do x = f(x)

  for x <- xs if x > 0
  yield x * x

  for
    x1 <- xs
    x2 <- xs
  do
    x1 * x2

  val useNewControlSyntax = Fact("use new control syntax")

  override def results = List(useNewControlSyntax)
}
