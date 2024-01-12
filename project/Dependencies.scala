/*
  * Copyright 2015 MongoDB, Inc.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *   http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */

import sbt._

object Dependencies {

  object Version {
    val slf4jV = "1.7.36"
    val specs2V = "4.16.1"
  }

  import Version._

  val mongoJavaDriver  = "org.mongodb" % "mongo-java-driver" % "3.2.2"
  val nScalaTime       = "com.github.nscala-time" %% "nscala-time" % "2.30.0"
  val scalatest = "org.scalatest" %% "scalatest" % "3.2.13"  % Test
  val slf4j            = "org.slf4j" % "slf4j-api" % slf4jV
  val slf4jJCL         = "org.slf4j" % "slf4j-jcl" % slf4jV % Test
  val specs2Core = "org.specs2" %% "specs2-core" % specs2V % Test
  val specs2Junit = "org.specs2" %% "specs2-junit" % specs2V % Test
  val specs2Mock = "org.specs2" %% s"specs2-mock" % specs2V % Test
  val collectionCompat = "org.scala-lang.modules" %% "scala-collection-compat" % "2.11.0"


}
