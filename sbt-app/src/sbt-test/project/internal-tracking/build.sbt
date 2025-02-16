ThisBuild / scalaVersion := "2.12.20"
ThisBuild / trackInternalDependencies := TrackLevel.NoTracking

lazy val root = (project in file("."))
  .aggregate(a, b, c, d)

lazy val a = (project in file("a"))

lazy val b = (project in file("b"))
  .dependsOn(a)

lazy val c = (project in file("c"))
  .settings(
    exportToInternal := TrackLevel.NoTracking
  )

lazy val d = (project in file("d"))
  .dependsOn(c)
  .settings(
    trackInternalDependencies := TrackLevel.TrackIfMissing
  )
