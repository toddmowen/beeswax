uniform.project("ebenezer-example1", "au.com.cba.omnia.ebenezer.example1")

uniformThriftSettings

uniformDependencySettings

uniformAssemblySettings

libraryDependencies ++=
  depend.hadoop() ++ depend.scalding() ++ depend.scalaz() ++ depend.testing() ++ Seq(
    "au.com.cba.omnia"        %% "thermometer"        % "0.1.0-20140604034707-ce7a9d3"
  )
