uniform.project("beeswax", "au.com.cba.omnia.beeswax")

uniform.docSettings("https://github.com/CommBank/beeswax")
uniform.ghsettings

updateOptions                     := updateOptions.value.withCachedResolution(true)
parallelExecution         in Test := false

uniformDependencySettings
uniformThriftSettings
strictDependencySettings

val omnitoolVersion    = "1.14.1-20160617114243-1143bc9"
val thermometerVersion = "1.4.3-20160617114144-562e6e0"
val humbugVersion      = "0.7.2-20160617114039-c10e869"

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

