package io.ceai.workshop

object SierpinskiTriangle {

  type Board = Seq[Seq[Char]] // Board ordered as Row[Column[Char]] 0 .. Rows - 1 x 0 .. Columns - 1

  /* Dimensions */
  val MaxSteps = 5
  val Rows = Math.pow(2, MaxSteps).intValue() // 32
  val Columns = Rows * 2 - 1                  // 63

  /* Characters to draw on the board */
  val EmptyChar = '_'
  val FilledChar = '1'

  /**
    * HINT: Use Seq.tabulate or Seq.fill
    * @return board filled with EmptyChars
    */
  val emptyBoard: Board = Seq.tabulate(Rows, Columns)((_, _) => EmptyChar)

  /**
    * Transforms board instance to printable multiline string
    * HINT: Use String.mkString and Seq.map functions
    */
  def boardToString(b: Board): String = b.map(_.mkString("")).mkString("\n")

  /**
    * Puts FilledChar at a position of a triangle
    */
  def applyTriangle(b: Board, t: Triangle): Board = {
    b.zipWithIndex.map {
      case (row, rowNumber) if t.top.row until t.top.row + t.height contains rowNumber =>
        row.slice(0, t.top.column - (rowNumber - t.top.row)) ++
          Seq.fill(2 * (rowNumber - t.top.row) + 1)(FilledChar) ++
          row.slice(t.top.column + (rowNumber - t.top.row) + 1, Columns)
      case (row, _) => row
    }
  }

  def main(args: Array[String]): Unit = {
    assert(MaxSteps > 0, "There has to be at least one recursion step")
    val triangles = Triangle.splitN(Seq(Triangle.largest), MaxSteps)
    val board = triangles.foldLeft(emptyBoard)(applyTriangle)
    println(boardToString(board))
  }

}
