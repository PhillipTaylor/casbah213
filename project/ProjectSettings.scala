import sbt.Keys._
import sbt._

object ProjectSettings {

  lazy val commonProfile: Project => Project = _
    .settings(
      scalacOptions ~=
        (_.filterNot(
          Set(
            "-Wdead-code",
            "-Wunused:params",
            "-Ywarn-dead-code",
            "-Ywarn-unused:params",
            "-Ywarn-unused:patvars",
            "-Wunused:explicits",
            "-Xlint:infer-any",
            "-Ywarn-infer-any"
          )
        )),
      testFrameworks += TestFrameworks.Specs2,
      Test / parallelExecution := true
    )

  lazy val publishSkip: Project => Project = _.settings(
    publish / skip := true,
    publishLocal / skip := true,
    publishArtifact / skip := true,
    Keys.`package` := file("")
  )

}
