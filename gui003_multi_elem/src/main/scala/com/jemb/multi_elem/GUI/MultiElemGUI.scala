package com.jemb.multi_elem.GUI

import scala.swing.Swing
import scala.swing.{BoxPanel, Button, Label, MainFrame, Orientation}

class MultiElemGUI extends MainFrame{
  title = "GUI - Prueba Multi Elem"
  contents = new BoxPanel(Orientation.Vertical) {
    contents += new Label("Ventana Multi Elemento")
    contents += Swing.VStrut(10)
    contents += Swing.Glue
    contents += Button("Presionar") {println("Hola")}
    contents += Swing.VStrut(5)
    contents += Button("Close") {sys.exit(0)}
    border    = Swing.CompoundBorder(Swing.BeveledBorder(Swing.Lowered),
      Swing.EmptyBorder(10, 10, 10, 10))


  }
}
