package com.jemb.events02.GUI

import scala.swing.event.{EditDone, FocusLost, SelectionChanged}
import scala.swing.{BoxPanel, Button, ComboBox, Component, Dimension, Label, MainFrame, Orientation, ScrollPane, Swing, TextArea, TextField}

class VentanaGUI extends MainFrame{
  title = "GUI - Eventos 02"
  val nombreTxt = new TextField(columns = 32)
  val apePatTxt = new TextField(columns = 32)
  val apeMatTxt = new TextField(columns = 32)
  val sexoCB = new ComboBox(List("desconocido", "masculino", "femenino"))
  val comentTxt = new TextArea { rows = 8; lineWrap = true; wordWrap = true }
  comentTxt.focusable = true

  restrictHeight(nombreTxt)
  restrictHeight(apePatTxt)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Nombre: ")
      contents += Swing.HStrut(5)
      contents += nombreTxt
    }
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Apellido Paterno: ")
      contents += Swing.HStrut(5)
      contents += apePatTxt
    }
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Apellido Materno: ")
      contents += Swing.HStrut(5)
      contents += apeMatTxt
    }
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Sexo: ")
      contents += Swing.HStrut(5)
      contents += sexoCB
    }
    contents += Swing.VStrut(5)
    contents += new Label("Comentarios: ")
    contents += Swing.VStrut(3)
    contents += new ScrollPane(comentTxt)
    contents += Button("Close") { sys.exit(0) }

  }
  listenTo(nombreTxt)
  listenTo(apePatTxt)
  listenTo(apeMatTxt)
  listenTo(sexoCB.selection)
  listenTo(comentTxt)

  reactions += {
    case EditDone(`nombreTxt`) => println(s"Nombre: ${nombreTxt.text}")
    case EditDone(`apePatTxt`) => println(s"Ape. Pat.: ${apePatTxt.text}")
    case EditDone(`apeMatTxt`) => println(s"Ape. Mat.: ${apeMatTxt.text}")
    case SelectionChanged(`sexoCB`) =>
      println("Genero: " + sexoCB.selection.item)
    case FocusLost(`comentTxt`,_,_) => println(s"Comentarios: ${comentTxt.text}")

  }

  def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }
}

