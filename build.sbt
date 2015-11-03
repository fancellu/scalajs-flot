lazy val example = project.enablePlugins(ScalaJSPlugin).dependsOn(core)

lazy val core = project.enablePlugins(ScalaJSPlugin)

lazy val root = (project in file(".")).enablePlugins(ScalaJSPlugin).dependsOn(core, example).aggregate(core, example).settings(scalaVersion := "2.11.7")
