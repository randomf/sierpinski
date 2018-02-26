package io.ceai.workshop

import org.scalatest.{FlatSpec, Matchers}

class SierpinskiTriangleTest extends FlatSpec with Matchers {

  behavior of "SierpinskiTriangle"

  it should "match emptyBoard" in {
    SierpinskiTriangle.emptyBoard should have size SierpinskiTriangle.Rows
    SierpinskiTriangle.emptyBoard.foreach { row =>
      row should have size SierpinskiTriangle.Columns
      row should contain only SierpinskiTriangle.EmptyChar
    }
  }

  it should "draw board empty board using boardToString()" in {
    SierpinskiTriangle.boardToString(SierpinskiTriangle.emptyBoard) should be (
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________\n" +
      "_______________________________________________________________"
    )
  }

  it should "draw a large triangle spanning through whole board" in {
    SierpinskiTriangle.boardToString(
      SierpinskiTriangle.applyTriangle(SierpinskiTriangle.emptyBoard, Triangle.largest)
    ) should be (
      "_______________________________1_______________________________\n" +
      "______________________________111______________________________\n" +
      "_____________________________11111_____________________________\n" +
      "____________________________1111111____________________________\n" +
      "___________________________111111111___________________________\n" +
      "__________________________11111111111__________________________\n" +
      "_________________________1111111111111_________________________\n" +
      "________________________111111111111111________________________\n" +
      "_______________________11111111111111111_______________________\n" +
      "______________________1111111111111111111______________________\n" +
      "_____________________111111111111111111111_____________________\n" +
      "____________________11111111111111111111111____________________\n" +
      "___________________1111111111111111111111111___________________\n" +
      "__________________111111111111111111111111111__________________\n" +
      "_________________11111111111111111111111111111_________________\n" +
      "________________1111111111111111111111111111111________________\n" +
      "_______________111111111111111111111111111111111_______________\n" +
      "______________11111111111111111111111111111111111______________\n" +
      "_____________1111111111111111111111111111111111111_____________\n" +
      "____________111111111111111111111111111111111111111____________\n" +
      "___________11111111111111111111111111111111111111111___________\n" +
      "__________1111111111111111111111111111111111111111111__________\n" +
      "_________111111111111111111111111111111111111111111111_________\n" +
      "________11111111111111111111111111111111111111111111111________\n" +
      "_______1111111111111111111111111111111111111111111111111_______\n" +
      "______111111111111111111111111111111111111111111111111111______\n" +
      "_____11111111111111111111111111111111111111111111111111111_____\n" +
      "____1111111111111111111111111111111111111111111111111111111____\n" +
      "___111111111111111111111111111111111111111111111111111111111___\n" +
      "__11111111111111111111111111111111111111111111111111111111111__\n" +
      "_1111111111111111111111111111111111111111111111111111111111111_\n" +
      "111111111111111111111111111111111111111111111111111111111111111"
    )
  }

  behavior of "Triangle"

  it should "split large triangles into three" in {
    Triangle.split(Triangle.largest) should contain allElementsOf Seq(
      Triangle(Point(31, 0), 16),
      Triangle(Point(15, 16), 16),
      Triangle(Point(47, 16), 16)
    )
  }

  it should "leave small triangle as it is" in {

  }

}
