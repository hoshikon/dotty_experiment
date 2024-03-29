lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-experiment",
    version := "0.1.0",

    scalaVersion := "3.2.0",

    scalacOptions ++= Seq("-Yexplicit-nulls", "-Ycheck-init"),

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )

mainClass in (Compile, run) := Some("Main")
