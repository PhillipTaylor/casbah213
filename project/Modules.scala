import sbt.Keys._
import sbt._

object Modules {
  lazy val commons: Project => Project = _
    .configure(ProjectSettings.commonProfile)
    .settings(name := "casbah-commons")
    .settings(
      libraryDependencies ++= Seq(
        Dependencies.mongoJavaDriver,
        Dependencies.nScalaTime,
        Dependencies.scalatest,
        Dependencies.specs2Core,
        Dependencies.specs2Junit,
        Dependencies.specs2Mock,
        Dependencies.slf4j,
        Dependencies.slf4jJCL,
        Dependencies.collectionCompat
      )
    )
    .settings(Test / packageBin / publishArtifact := true)

  lazy val core: Project => Project = _
    .configure(ProjectSettings.commonProfile)
    .settings(name := "casbah-core")
    .settings(Test / parallelExecution := false)

  lazy val query: Project => Project = _
    .configure(ProjectSettings.commonProfile)
    .settings(name := "casbah-query")

  lazy val gridfs: Project => Project = _
    .configure(ProjectSettings.commonProfile)
    .settings(name := "casbah-gridfs")

  lazy val examples: Project => Project = _
    .configure(ProjectSettings.commonProfile)
    .configure(ProjectSettings.publishSkip)
    .settings(name := "casbah-examples")
}
