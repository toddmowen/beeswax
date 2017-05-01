uniform.project("beeswax", "au.com.cba.omnia.beeswax")

uniform.docSettings("https://github.com/CommBank/beeswax")
uniform.ghsettings

updateOptions                     := updateOptions.value.withCachedResolution(true)
parallelExecution         in Test := false

uniformDependencySettings
uniformThriftSettings
strictDependencySettings

val omnitoolVersion    = "1.14.7-20170501021358-bdf725d"
val thermometerVersion = "1.5.10-20170501023059-67accaf"

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

