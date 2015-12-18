uniform.project("beeswax", "au.com.cba.omnia.beeswax")

uniform.docSettings("https://github.com/CommBank/beeswax")
uniform.ghsettings

updateOptions                     := updateOptions.value.withCachedResolution(true)
parallelExecution         in Test := false

uniformDependencySettings
uniformThriftSettings
strictDependencySettings

val omnitoolVersion    = "1.12.0-20151021050758-700b9d0"
val thermometerVersion = "1.3.0-20151122230202-55282c8"
val humbugVersion      = "0.6.1-20151008040202-1f0ccb9"

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

