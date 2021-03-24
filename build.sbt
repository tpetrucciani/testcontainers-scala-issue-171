inThisBuild(
  List(
    name := "testcontainers-scala-issue-171",
    version := "1.0.0",
    scalaVersion := "2.12.13",
    testFrameworks += new TestFramework("munit.Framework"),
  ),
)

lazy val root = project
  .in(file("."))
  .settings(
    libraryDependencies ++= List(
      "org.scalameta" %% "munit" % "0.7.5",
      "com.dimafeng" %% "testcontainers-scala-munit" % "0.39.3",
      "com.dimafeng" %% "testcontainers-scala-postgresql" % "0.39.3",
    ).map(_ % Test),
  )
