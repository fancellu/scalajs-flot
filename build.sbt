import com.lihaoyi.workbench.Plugin._

enablePlugins(ScalaJSPlugin)

workbenchSettings

name := "Scala.js+Flot examples"

version := "0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.2",
  "be.doeraene" %%% "scalajs-jquery" % "0.8.1" 
)

bootSnippet := "example.T1().main(document.getElementById('mydiv'));"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)

