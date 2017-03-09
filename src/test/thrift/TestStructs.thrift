//   Copyright 2014 Commonwealth Bank of Australia
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

#@namespace scala au.com.cba.omnia.beeswax

struct Primitives {
  1: bool   boolean
  2: byte   bytey
  3: i16    short
  4: i32    integer
  5: i64    long
  6: double doubley
  7: string stringy
}

struct Listish {
  1: i16 short
  2: list<i32> listy
}

struct Mapish {
  1: i16 short
  2: map<i32, string> mapy
}

struct Nested {
  1: map<i32, map<string, list<i32>>> nested
}

struct StructishPrimitives {
1: i16 short
2: Primitives primitives
}

struct StructishMap {
1: i16 short
2: Mapish mapish
}

struct StructishList {
1: i16 short
2: Listish listy
}

struct ListishStruct {
1: i16 short
2: list<Listish> listy
}

struct MapishStruct {
1: i16 short
2: map<i32, Listish> mappy
}