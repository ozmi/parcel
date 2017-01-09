enablePlugins(ScalaJSPlugin)

name := "parcel"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.1"

libraryDependencies += "com.lihaoyi" %%% "utest" % "0.4.4" % "test"
testFrameworks += new TestFramework("utest.runner.Framework")

skip in packageJSDependencies := false

jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"

jsDependencies += RuntimeDOM

persistLauncher := true