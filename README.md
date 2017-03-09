beeswax
=======

[![Build Status](https://travis-ci.org/CommBank/beeswax.svg?branch=master)](https://travis-ci.org/CommBank/beeswax)
[![Gitter chat](https://badges.gitter.im/CommBank/maestro.png)](https://gitter.im/CommBank/maestro)


```
Monadic wrapper for the Hive API.
```

[Scaladoc](https://commbank.github.io/beeswax/latest/api/index.html)

Usage
-----

See https://commbank.github.io/beeswax/index.html

### Creating a table

Table schemas are derived from a thrift struct. The underlying storage format can either be text or
parquet. Here is an example:

```scala
Hive.createParquetTable[Pair]("database", "table", List(("year", "int"), ("name", "string")))
```

### Querying

Create actions that perform hive queries.

```scala
Hive.query("SELECT COUNT(*) FROM datable.table")
```

### Multiple operations

Creates a table and inserts data into it from another table.

```scala
for {
  _ <- Hive.createTexttable[Pair]("test", "pairs", List.empty)
  _ <- Hive.query("INSERT INTO TABLE test.pairs FROM SELECT * FROM test2.pairs")
} yield ()
```

### Running the Hive monad

```scala
import org.apache.hadoop.hive.conf.HiveConf

val hc: HiveConf                 = new HiveConf
val q: Hive[List[String]]        = Hive.query("SELECT COUNT(*) FROM datable.table")
val result: Result[List[String]] = q.run(hc)
```

Known Issues
------------

* Need to specify the Hive metastore as a thrift endpoint instead of the database.

  ```
    <property>
      <name>hive.metastore.uris</name>
      <value>thrift://metastore:9083</value>
    </property>
    ```

* In order to run queries the hive-site.xml need to include the `yarn.resourcemanager.address`
  property even if the value is bogus.

  ```
    <property>
      <name>yarn.resourcemanager.address</name>
      <value>bogus</value>
    </property>
  ```
* In order to run queries with partitioning the partition mode needs to be set to nonstrict.

  ```
    <property>
      <name>hive.exec.dynamic.partition.mode</name>
      <value>nonstrict</value>
    </property>
  ```
