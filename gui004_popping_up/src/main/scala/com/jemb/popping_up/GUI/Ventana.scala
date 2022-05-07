package com.jemb.popping_up.GUI

import java.awt.Color
import scala.swing.{BoxPanel, Button, Dialog, Label, MainFrame, Orientation, Swing}

class Ventana extends MainFrame{
  val la = new Label("Popping Up")

  la.foreground = Color.BLUE
  title = "Popping Up"

  contents = new BoxPanel(Orientation.Vertical){
    contents += la
    contents += Swing.VStrut(10)
    contents += Swing.Glue
    contents += Button("Presionar") { pressMe() }
    contents += Swing.VStrut(5)
    contents += Button("Cambiar Texto") { changeText() }
    contents += Swing.VStrut(5)
    contents += Button("Close") { closeMe() }
    border = Swing.EmptyBorder(10, 10, 10, 10)

  }

  def pressMe():Unit = {
    Dialog.showMessage(contents.head, "Gracias", "Información")
  }

  def changeText():Unit = {
    val r = Dialog.showInput(contents.head, "Nueva etiqueta", initial = la.text)
    r match {
      case Some(nvoTxt) => la.text = nvoTxt
      case None =>
    }
  }

  def closeMe():Unit = {
    val res = Dialog.showConfirmation(contents.head,
      "Do you really want to quit?",
      optionType=Dialog.Options.YesNo,
      title=title)
    if (res == Dialog.Result.Ok) sys.exit(0)
  }
}
