name := "scalajs-flot"
description := "Scala.js+Flot examples"
version := "0.2"
scalaVersion := "2.11.7"
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.2",
  "be.doeraene" %%% "scalajs-jquery" % "0.8.1" 
)

publishArtifact in packageDoc:= false

publishArtifact in packageSrc:= false

