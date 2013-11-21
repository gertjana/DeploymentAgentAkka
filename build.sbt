// Set the project name to the string 'My Project'
name := "Deployment Agent Akka"

version := "0.0.1"

scalaVersion := "2.10.1"

//Add Repository Path
//resolvers += "db4o-repo" at "http://source.db4o.com/maven"

// add compile dependencies on some dispatch modules
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster" % "2.2.3"
)