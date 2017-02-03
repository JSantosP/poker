name := "poker"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
    "org.scalacheck" %% "scalacheck" % "1.13.4",
    "org.scalatest" %% "scalatest" % "3.0.1" % "test")
}

dependencyOverrides ++= Set(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5")
