package random

import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

object Random {
  import RandomExtern._

  def random(nbytes: Int): Array[UByte] = {
    val arr = Array.ofDim[UByte](nbytes)

    Zone { implicit z =>
      {
        val size = nbytes.toLong.toULong
        val data = alloc[UByte](size).asInstanceOf[Ptr[UByte]]
        val res = fill_random(data, size)
        if (res == 0) throw Exception("failed to gather randomness from system")

        for (i <- 0 until nbytes) arr(i) = !(data + i)
      }
    }

    arr
  }
}

@extern
object RandomExtern {
  def fill_random(data: Ptr[UByte], size: CSize): Int = extern
}
