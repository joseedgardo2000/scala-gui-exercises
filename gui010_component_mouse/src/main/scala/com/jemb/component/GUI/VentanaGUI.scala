package com.jemb.component.GUI

import com.jemb.component.components.{Board, Canvas, TicTacToeEvent}

import java.awt.Color
import scala.swing.{BoxPanel, Button, Component, Dimension, Label, MainFrame, Orientation, Swing}

class VentanaGUI(val board: Board) extends MainFrame {
  //------ Constructor -------------
  title = "Tic Tac Toe"
  val canvas = new Canvas(board)
  val newGameButton = Button("New Game") { newGame() }
  val turnLabel = new Label("Player 1's turn")
  turnLabel.foreground = Color.BLUE
  val quitButton = Button("Quit") { sys.exit(0) }
  val buttonLine = new BoxPanel(Orientation.Horizontal) {
    contents += newGameButton
    contents += Swing.HGlue
    contents += turnLabel
    contents += Swing.HGlue
    contents += quitButton
  }

  // make sure that resizing only changes the TicTacToeDisplay
  restrictHeight(buttonLine)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += canvas
    contents += Swing.VStrut(10)
    contents += buttonLine
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }
  listenTo(canvas)
  reactions += {
    case TicTacToeEvent(x, y) =>
      board.play(x, y)
      updateLabelAndBoard()
  }
  //------ ----------- -------------
  def updateLabelAndBoard() {
    turnLabel.text = "Player %d's turn".format(board.currentPlayer)
    canvas.repaint()
  }

  def newGame() {
    board.restart()
    updateLabelAndBoard()
    println("New Game!")
  }
  private def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }
}
