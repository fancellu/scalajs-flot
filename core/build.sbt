name := "scalajs-flot"

description := "Scala.js+Flot examples"

version := "0.4"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "be.doeraene" %%% "scalajs-jquery" % "0.9.0" 
)

publishArtifact in packageDoc:= false

publishArtifact in packageSrc:= false


