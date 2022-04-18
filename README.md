sn-random
=========

Secure randomness for Linux, Mac, Windows, OpenBSD and FreeBSD in C for Scala 3 Native.

Installation
------------

```sbt
libraryDependencies += "com.fiatjaf" %%% "sn-random" % "0.1.0"
```

Usage
-----

This library provides a single `random()` function that takes a number of bytes as an `Int` and outputs an `Array[UByte]` filled with that number of random bytes.

```scala
import scala.scalanative.unsigned._
import random.Random.random

random(3)
// ==> Array[UByte](82, 162, 5)

random(10)
  .map(_.toHexString)
  .map(x => if (x.size == 2) x else s"0$x")
  .mkString
// ==> "017cb4f0347c0974f9a6"
```
