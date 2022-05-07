package com.jemb.components.GUI

import scala.swing.{BoxPanel, Button, ButtonGroup, CheckBox, ComboBox, Component, Dimension, Label, MainFrame, Orientation, RadioButton, ScrollPane, Swing, TextArea, TextField, ToggleButton}

class VentanaGUI extends MainFrame {
  def restrictHeight(s:Component):Unit = {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }

  def reportAndClose(): Unit = {
    println("Nombre: " + nameField.text)
    println("Gusta de Scala: " + likeScala.selected)
    println("Licenciatura: " + status1.selected)
    println("Postgrado: " + status2.selected)
    println("Profesor: " + status3.selected)
    println("Gender: " + gender.selection.item +
      " (Index: " + gender.selection.index + ")")
    println("Comments: " + commentField.text)
    println("'Press me' is pressed: " + pressMe.selected)
    sys.exit(0)
  }

  title = "GUI - Components"
  val nameField:TextField = new TextField { columns = 32 }
  val likeScala = new CheckBox("Me gusta Scala")
  likeScala.selected = true
  val status1 = new RadioButton("Licenciatura")
  val status2 = new RadioButton("Postgrado")
  val status3 = new RadioButton("Profesor")
  status3.selected = true
  val statusGroup = new ButtonGroup(status1, status2, status3)
  val gender = new ComboBox(List("Desconocido", "Hombre", "Mujer"))
  val commentField:TextArea = new TextArea { rows = 8; lineWrap = true; wordWrap = true }
  val pressMe = new ToggleButton("Presionar")
  pressMe.selected = true

  restrictHeight(nameField)
  restrictHeight(gender)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("My name: ")
      contents += Swing.HStrut(5)
      contents += nameField
    }
    contents += Swing.VStrut(5)
    contents += likeScala
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += status1
      contents += Swing.HStrut(10)
      contents += status2
      contents += Swing.HStrut(10)
      contents += status3
    }
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Gender")
      contents += Swing.HStrut(20)
      contents += gender
    }
    contents += Swing.VStrut(5)
    contents += new Label("Comments")
    contents += Swing.VStrut(3)
    contents += new ScrollPane(commentField)
    contents += Swing.VStrut(5)
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += pressMe
      contents += Swing.HGlue
      contents += Button("Close") { reportAndClose() }
    }
    for (e <- contents)
      e.xLayoutAlignment = 0.0
    border = Swing.EmptyBorder(10, 10, 10, 10)
  }




  visible = true
}
