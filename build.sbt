import sbt._
import Keys._
import sbtassembly.AssemblyPlugin.autoImport._
import Common._

lazy val commonSettings = Seq(
  version := "0.1",
  organization := "com.odeklas",
  scalaVersion := commonScalaVersion
)

	lazy val app =(project in file("app")).
	settings(commonSettings: _*).
	settings(
	    scalacOptions := commonScalacOptions,
		libraryDependencies ++= commonLibraries)
	