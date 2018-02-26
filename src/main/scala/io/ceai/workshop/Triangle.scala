package io.ceai.workshop

import scala.annotation.tailrec

case class Triangle(top: Point, height: Int)

object Triangle {

  val largest = Triangle(Point(SierpinskiTriangle.Columns / 2, 0), SierpinskiTriangle.Rows)

  def split(t: Triangle): Seq[Triangle] = {
    if (t.height > 2) {
      Seq(???, ???, ???)
    } else {
      Seq(???)
    }
  }

  @tailrec
  def splitN(acc: Seq[Triangle], steps: Int): Seq[Triangle] = if (steps < 1) ??? else splitN(???, steps - 1)
}
