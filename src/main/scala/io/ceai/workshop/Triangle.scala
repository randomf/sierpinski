package io.ceai.workshop

import scala.annotation.tailrec

case class Triangle(top: Point, height: Int)

object Triangle {

  val largest = Triangle(Point(SierpinskiTriangle.Columns / 2, 0), SierpinskiTriangle.Rows)

  def split(t: Triangle): Seq[Triangle] = {
    if (t.height > 2) {
      Seq(
        Triangle(t.top, t.height / 2),
        Triangle(Point(t.top.column - t.height / 2, t.top.row + t.height / 2), t.height / 2),
        Triangle(Point(t.top.column + t.height / 2, t.top.row + t.height / 2), t.height / 2)
      )
    } else {
      Seq(t)
    }
  }

  @tailrec
  def splitN(acc: Seq[Triangle], steps: Int): Seq[Triangle] = if (steps < 1) acc else splitN(acc.flatMap(split), steps - 1)
}
