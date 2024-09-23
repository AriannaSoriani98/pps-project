ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "macro3",
    libraryDependencies += "junit" % "junit" % "4.13.2" % Test
  )
