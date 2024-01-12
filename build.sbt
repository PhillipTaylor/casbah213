Global / crossScalaVersions := Seq("2.12.16", "2.13.8")
Global / scalaVersion := crossScalaVersions.value.last
Global / credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
Global / organization := "uk.gov.homeoffice"
Global / versionScheme := Some(VersionScheme.EarlySemVer)
Global / version := "5.0.0"

Global / resolvers ++= Seq(
      "Artifactory Snapshot Realm" at "https://artifactory.digital.homeoffice.gov.uk/artifactory/libs-snapshot-local/",
      "Artifactory Release Realm" at "https://artifactory.digital.homeoffice.gov.uk/artifactory/libs-release-local/",
      "Artifactory External Release Local Realm" at "https://artifactory.digital.homeoffice.gov.uk/artifactory/ext-release-local/"
    )
Global / publishTo := {
      val artifactory = sys.env.get("ARTIFACTORY_SERVER").getOrElse("https://artifactory.digital.homeoffice.gov.uk/")
      Some("release"  at artifactory + "artifactory/libs-release-local")
    }

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
  )
)


publishArtifact in (Test, packageBin) := true
publishArtifact in (Test, packageDoc) := true
publishArtifact in (Test, packageSrc) := true

Global / onChangedBuildSource := ReloadOnSourceChanges
// format: on
