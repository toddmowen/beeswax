uniform.project("beeswax", "au.com.cba.omnia.beeswax")

uniform.docSettings("https://github.com/CommBank/beeswax")
uniform.ghsettings

updateOptions                     := updateOptions.value.withCachedResolution(true)
parallelExecution         in Test := false

uniformDependencySettings
uniformThriftSettings
strictDependencySettings

val omnitoolVersion    = "1.14.2-20161028030316-93de570"
val thermometerVersion = "1.4.6-20161026213817-fb25e67"
val humbugVersion      = "0.7.3-20161026213926-d09fb4b"

libraryDependencies :=
  depend.hadoopClasspath ++
  depend.hadoop() ++
  depend.testing() ++
  depend.hive() ++
  depend.parquet() ++
  depend.omnia("omnitool-core", omnitoolVersion) ++
  depend.omnia("thermometer-hive", thermometerVersion, "test") ++
  Seq(
    "org.specs2"               %% "specs2-core"   % depend.versions.specs,
    "com.twitter"              %% "scrooge-core"  % depend.versions.scrooge,
    "au.com.cba.omnia"         %% "omnitool-core" % omnitoolVersion % "test" classifier "tests"
  )

