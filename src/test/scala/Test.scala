import scala.scalanative.unsigned._
import utest._
import random.Random

object RandomText extends TestSuite {
  def bytearrayToHex(ba: Array[UByte]): String =
    ba.map(_.toHexString)
      .map(x =>
        if (x.size == 2) x
        else s"0$x"
      )
      .mkString

  val tests = Tests {
    test("gather randomness") {
      val r1 = Random.random(73)
      val r2 = Random.random(73)
      val r3 = Random.random(73)
      val r4 = Random.random(73)

      r1.size ==> 73
      r2.size ==> 73
      r3.size ==> 73
      r4.size ==> 73

      val h1 = bytearrayToHex(r1)
      val h2 = bytearrayToHex(r2)
      val h3 = bytearrayToHex(r3)
      val h4 = bytearrayToHex(r4)

      println(h1)
      println(h2)
      println(h3)
      println(h4)

      assert(h1 != h2, h1 != h3, h1 != h3, h2 != h3, h3 != h4)
    }
  }
}
