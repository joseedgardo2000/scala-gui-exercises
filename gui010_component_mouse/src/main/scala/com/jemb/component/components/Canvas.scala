package com.jemb.component.components

import java.awt.{BasicStroke, Color}
import java.awt.geom.{Ellipse2D, Line2D}
import scala.swing.event.MouseClicked
import scala.swing.{Component, Dimension, Graphics2D}



class Canvas(val board:Board) extends Component{
  preferredSize = new Dimension(320,320)
  //-------- Relacionado al Mouse --------------------
  listenTo(mouse.clicks)
  reactions += {
    case MouseClicked(_, p, _, _, _) => mouseClick(p.x, p.y)
  }

  private def squareGeometry:(Int, Int, Int, Int) = {
    val d = size
    val squareSide = d.height min d.width
    val x0 = (d.width - squareSide)/2
    val y0 = (d.height -squareSide)/2
    (squareSide, x0, y0, squareSide/3)
  }

  private def mouseClick(x: Int, y: Int):Unit = {
    val (squareSide, x0, y0, wid) = squareGeometry
    if(x0 <= x && x < x0 + squareSide &&
      y0 <= y && y < y0 + squareSide){
      val col = (x - x0) / wid
      val row = (y - y0) / wid
      printf("Mouse pressed in field %d, %d\n", col, row)
      publish(TicTacToeEvent(col, row))
    }
  }
  //--------------------------------------------------

  override def paintComponent(g: Graphics2D): Unit = {
    val d = size
    g.setRenderingHint(
      java.awt.RenderingHints.KEY_ANTIALIASING,
      java.awt.RenderingHints.VALUE_ANTIALIAS_ON)
    g.setColor(Color.WHITE)
    g.fillRect(0, 0, d.width, d.height)
    val (squareSide, x0, y0, wid) = squareGeometry
    g.setColor(Color.BLACK)
    // vertical lines
    for (x <- 1 to 2)
      g.draw(new Line2D.Double(x0 + x * wid, y0, x0 + x * wid, y0 + squareSide))
    // horizontal lines
    for (y <- 1 to 2)
      g.draw(new Line2D.Double(x0, y0 + y * wid, x0 + squareSide, y0 + y * wid))
    g.setStroke(new BasicStroke(3f))
    for (x <- 0 until 3) {
      for (y <- 0 until 3) {
        board(x, y) match {
          case 1 =>
            g.setColor(Color.RED)
            g.draw(new Ellipse2D.Double(x0 + x * wid + 10, y0 + y * wid + 10,
              wid - 20, wid - 20))
          case 2 =>
            g.setColor(new Color(0, 160, 0))
            val x1 = x0 + x * wid + 10
            val y1 = y0 + y * wid + 10
            g.draw(new Line2D.Double(x1, y1, x1 + wid - 20, y1 + wid - 20))
            g.draw(new Line2D.Double(x1, y1 + wid - 20, x1 + wid - 20, y1))
          case _ =>
        }
      }
    }

  }
}
