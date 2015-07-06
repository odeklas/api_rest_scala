import Common._
import sbt.Keys._
import sbt._

lazy val commonSettings = Seq(
  version := "0.1",
  organization := "com.odeklas",
  scalaVersion := commonScalaVersion
)

lazy val app =(project in file("app")).
	settings(commonSettings: _*).
	settings(
	    scalacOptions := commonScalacOptions,
		libraryDependencies ++= commonLibraries ++ reactiveLibraries)


libraryDependencies ++= commonLibraries ++ reactiveLibraries