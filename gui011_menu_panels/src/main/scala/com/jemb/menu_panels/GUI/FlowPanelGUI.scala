package com.jemb.menu_panels.GUI

import scala.swing.event.ButtonClicked
import scala.swing.{Action, Button, Dialog, FlowPanel, Frame, Label, MainFrame, Swing}

class FlowPanelGUI extends Dialog  {
  title = "Flow Panel GUI"
  modal = true
  val cerrarBoton = new Button("Cerrar")
  contents = new FlowPanel {
    contents += new Label("FlowPanel lays out its components from left to ")
    contents += new Label("right, with some separating space in between")
    contents += Swing.HStrut(30)
    contents += new Button(Action("Un Botón") {
      Dialog.showMessage(contents.head, "La acción del botón", "Información")
    })
    contents += new Button(Action("Otro Botón") {
      Dialog.showMessage(contents.head, "La acción del otro botón", "Información")
    })
    contents += Swing.HStrut(30)
    contents += cerrarBoton
  }

  listenTo(cerrarBoton)

  reactions += {
    case ButtonClicked(`cerrarBoton`) => this.dispose()
  }
}