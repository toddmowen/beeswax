uniform.project("ebenezer-hive", "au.com.cba.omnia.ebenezer.scrooge.hive")

uniformThriftSettings

uniformDependencySettings

libraryDependencies ++=
  depend.hadoop() ++ depend.scalding() ++ depend.scalaz() ++ depend.testing() ++ 
depend.omnia("cascading-beehaus", "0.1.0-20140526050833-5901095") ++
  Seq(
    "au.com.cba.omnia"        %% "thermometer"        % "0.0.1-20140320004039-cf3a3f5" % "test",
    "com.twitter"             %  "parquet-hive"                       % "1.3.2",
    "com.twitter"             %  "parquet-hive-0.10-binding"          % "1.3.2",
    "com.twitter"             %  "parquet-hive-storage-handler"       % "1.3.2"
  )