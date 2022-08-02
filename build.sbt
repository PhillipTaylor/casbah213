Global / crossScalaVersions := Seq("2.12.16", "2.13.8")
Global / scalaVersion := crossScalaVersions.value.last

lazy val commons = project
  .in(file("casbah-commons"))
  .configure(Modules.commons)

lazy val core = project
  .in(file("casbah-core"))
  .configure(Modules.core)
  .dependsOn(commons % "test->test;compile")
  .dependsOn(query)

lazy val query = project
  .in(file("casbah-query"))
  .configure(Modules.query)
  .dependsOn(commons % "test->test;compile")

lazy val gridfs = project
  .in(file("casbah-gridfs"))
  .configure(Modules.gridfs)
  .dependsOn(commons % "test->test")
  .dependsOn(core % "test->test;compile")

lazy val examples = project
  .in(file("examples"))
  .configure(Modules.examples)
  .aggregate(commons, core, query, gridfs)
  .dependsOn(commons, core, query, gridfs)

// format: off
inThisBuild(
  List(
    sonatypeCredentialHost := Sonatype.sonatype01,
    versionScheme := Some(VersionScheme.EarlySemVer),
    organization := "io.kinoplan",
    homepage := Some(url("https://github.com/kinoplan/utils")),
    licenses := Seq("Apache-2.0" -> url("https://opensource.org/licenses/Apache-2.0")),
    developers := List(Developer("kinoplan", "Kinoplan", "job@kinoplan.ru", url("https://kinoplan.tech"))),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/kinoplan/utils"),
        "scm:git:git@github.com:kinoplan/utils.git"
      )
    )
  )
)

Global / onChangedBuildSource := ReloadOnSourceChanges
// format: on
