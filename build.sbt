lazy val root = project
  .in(file("."))
  .settings(
    name := "Exploding-K",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.13.10",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.14",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test",
    libraryDependencies += "com.google.inject" % "guice" % "5.1.0",
    jacocoCoverallsRepoToken := sys.env.get("COVERALLS_REPO_TOKEN"),
      libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
  )
.enablePlugins(JacocoCoverallsPlugin)