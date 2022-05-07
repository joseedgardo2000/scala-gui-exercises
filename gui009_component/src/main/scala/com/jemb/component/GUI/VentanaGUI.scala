package com.jemb.component.GUI

import com.jemb.component.components.{Board, Canvas}

import scala.swing.{BoxPanel, Button, Component, Dimension, MainFrame, Orientation, Swing}

class VentanaGUI(val board: Board) extends MainFrame {
  //------ Constructor -------------
  title = "Tic Tac Toe"
  val canvas = new Canvas(board)
  val newGameButton = Button("New Game") { newGame() }
  val quitButton = Button("Quit") { sys.exit(0) }
  val buttonLine = new BoxPanel(Orientation.Horizontal) {
    contents += newGameButton
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
  //------ ----------- -------------
  def newGame() {
    println("New Game!")
  }
  private def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }
}
