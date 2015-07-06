import sbt._
import Keys._



object Common {

	autoScalaLibrary := false

	lazy val akkaVersion = "2.3.11"
	lazy val sprayVersion = "1.3.2"

	/**s
	 * Scala version
	 **/
	def commonScalaVersion = "2.11.7"

	/**
	 * scalac arguments
	 **/
	def commonScalacOptions = Seq(
		"-unchecked",
		"-deprecation",
		"-Xlint",
		"-Ywarn-dead-code",
		"-language:_",
		"-target:jvm-1.8",
		"-encoding", "UTF-8"
	)

	/**
	 * Maven repositories
	 **/
	def commonResolvers = Seq(
		"Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",		
		"Sonatype Releases"  at "http://oss.sonatype.org/content/repositories/releases",
		"Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
		"Spray.io repository" at "http://repo.spray.io",
		"joda-time" 		 		%	"joda-time" 			% "1.5.2",
		"org.slf4j" 				% 	"slf4j-api"				% "1.6.6"
	)

	/**
	 * Scala basic libraries
	 **/
	def commonScalaLibraries = Seq (
		"org.scala-lang" 					% "scala-library" 	% "2.11.7",
		"org.scala-lang" 					% "scala-compiler" 	% "2.11.7"
	)


	/*def mongoLibraries = Seq(
		"org.reactivemongo" 		%% 	"play2-reactivemongo" 	% "0.11.1"
	)*/

	def functionalProgrammingLibraries = Seq(
    "org.scalaz"          %%  "scalaz-core"   % "7.1.0"


  )

	def akkaLibraries = Seq(
	  	"com.typesafe.akka" 		%% "akka-actor" 			% akkaVersion ,
	  	"com.typesafe.akka" 		%% "akka-slf4j"       		% akkaVersion ,
	  	"com.typesafe.akka" 		%% "akka-testkit"       	% akkaVersion ,
	  	"com.typesafe.akka" 		%% "akka-remote" 			% akkaVersion,
	  	"ch.qos.logback"     		%  "logback-classic"  		% "1.0.13" 
  	)

  	def sprayLibraries = Seq(
      "io.spray"            %%  "spray-can"     % sprayVersion withSources() withJavadoc(),
      "io.spray"            %%  "spray-routing" % sprayVersion withSources() withJavadoc(),
      "io.spray"            %%  "spray-json"    % "1.3.1",
      "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test"
    )

  	def testingLibraries = Seq(
		"junit" 			 		%	"junit"				%	"4.10"		% "test",
		"com.jayway.restassured"	%	"rest-assured" 		%	"1.8.1"		% "test",
		"org.scalatest" 	 		% 	"scalatest_2.10" 	%	"1.9.1" 	% "test",
		"org.scalacheck" 			%%	"scalacheck" 		%	"1.11.1"	% "test"		
	)
/*
	def apacheCommonsLibraries = Seq( 
		"commons-logging" 			% 	"commons-logging" 	% "1.1.3",
		"org.apache.commons" 		% 	"commons-lang3" 	% "3.1",
		"commons-codec" 			% 	"commons-codec" 	% "1.8",
		"org.apache.httpcomponents"	 % "httpcore"			 % "4.0-beta3",
		"org.apache.httpcomponents"	 % "httpclient" 		 % "4.2.1",
		"org.apache.commons" 		 % "commons-io" 		 % "1.3.2"
	)*/

	def jacksonLibraries = Seq (
		"com.fasterxml.jackson.core" % "jackson-databind" % "2.0.1"

	)


  	def commonLibraries = functionalProgrammingLibraries ++ testingLibraries ++ commonScalaLibraries /*++ apacheCommonsLibraries*/ ++ jacksonLibraries
  	def reactiveLibraries = akkaLibraries ++ sprayLibraries

}
