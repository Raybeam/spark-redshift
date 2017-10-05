name := "spark-redshift"

organization := "com.raybeam"

version := "4.0.0-SNAPSHOT"

scalaVersion := "2.11.8"

lazy val sparkVersion = "2.2.0"

resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.5" % "provided",
  "com.eclipsesource.minimal-json" % "minimal-json" % "0.9.4",
  // We require spark-avro, but avro-mapred must be provided to match Hadoop version.
  // In most cases, avro-mapred will be provided as part of the Spark assembly JAR.
  "com.github.databricks" %% "spark-avro" % "204864b6cf",
  // Kryo is provided by Spark, but we need this here in order to be able to import KryoSerializable
  "com.esotericsoftware" % "kryo-shaded" % "3.0.3" % "provided",
  "com.amazonaws" % "aws-java-sdk" % "1.11.37" % "provided",
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
)
