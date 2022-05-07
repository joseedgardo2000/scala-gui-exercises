ThisBuild / version          := "0.0.1"
ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / organization     := "com.jemb"  
ThisBuild / organizationName := "jemb"

lazy val root = (project in file("."))
  .settings(
    name := "gui003_multi_elem"
  )

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"