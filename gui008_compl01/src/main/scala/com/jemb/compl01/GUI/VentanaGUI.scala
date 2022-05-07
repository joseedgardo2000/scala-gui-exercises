package com.jemb.compl01.GUI

import com.jemb.compl01.GUI.VentanaGUI.restrictHeight
import com.jemb.compl01.solucion.Solver

import java.awt.Font
import scala.swing.event.{ButtonClicked, EditDone}
import scala.swing.{BoxPanel, Button, ComboBox, Component, Dimension, MainFrame, Orientation, ScrollPane, Swing, TextArea, TextField}

class VentanaGUI(solver:Solver) extends MainFrame{

  title = "Crucigramer"
  var fontSize = 12
  val searchField = new TextField(columns = 32)
  val searchButton = new Button("Buscar")
  val searchLine = new BoxPanel(Orientation.Horizontal) {
    contents += searchField
    contents += Swing.HStrut(20)
    contents += searchButton
  }
  val resultField = new TextArea {
    rows = 10; lineWrap = true; wordWrap = true; editable = false
  }
  val dict = new ComboBox(List("Inglés", "Español"))
  val largerFont = Button("+") { fontChange(+1) }
  val smallerFont = Button("-") { fontChange(-1) }
  fontChange(0)

  restrictHeight(searchLine)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += searchLine
    contents += Swing.VStrut(10)
    contents += new ScrollPane(resultField)
    contents += Swing.VStrut(10)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += dict
      contents += Swing.HStrut(10)
      contents += largerFont
      contents += Swing.HStrut(10)
      contents += smallerFont
    }
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }

  listenTo(searchField)
  listenTo(searchButton)

  reactions += {
    case EditDone(`searchField`) => searchNow()
    case ButtonClicked(`searchButton`) => searchNow()
  }

  def fontChange(d: Int) {
    fontSize += d
    resultField.font = new Font(null, Font.PLAIN, fontSize)
  }

  def searchNow():Unit = {
    val pattern = searchField.text.toLowerCase
    val words = solver.findWords(pattern, dict.selection.index)
    if (words.length == 0) {
      resultField.text = "\n\nSorry, no words found."
    } else {
      resultField.text = words.sorted mkString "\n"
      resultField.caret.position = 0
    }
  }
}

object VentanaGUI {
  private def restrictHeight(s:Component):Unit = {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }
}
