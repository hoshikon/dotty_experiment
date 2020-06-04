package othernew

import util.{AppWithPrint, Fact}

object CreatorApplications extends AppWithPrint("Creator Applications") {

  class Fruit(name: String)
  val kiwi = Fruit("Kiwi") //no need to prepend the 'new' keyword

  //the compiler adds a new possible interpretation to a functional call f(args)
  // if f is a method applicable to args => f(arfs)
  // otherwise if f has an apply method applicable to args => f.apply(args)
  // otherwise if f is of the form p.m and there is an implicit conversion c applicable
  // to p so that c(p).m is applicable to args => c(p).m(args)
  // otherwise (this is new) if f is a syntactically stable identifier and new f
  // where f is interpreted as a type identifier is applicable to args => new f(args)

  val createAnInstanceUsingCreatorApplication =
    Fact("create an instance using creator application")

  override val results = List(createAnInstanceUsingCreatorApplication)
}
