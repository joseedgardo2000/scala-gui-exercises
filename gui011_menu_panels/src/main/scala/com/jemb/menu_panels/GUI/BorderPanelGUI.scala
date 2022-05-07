package com.jemb.menu_panels.GUI

import scala.swing.{Action, BorderPanel, Button, Dialog}

class BorderPanelGUI extends Dialog{
  title = "Flow Panel GUI"
  modal = true
  contents = new BorderPanel {
    add(new Button(Action("Norte")
      {Dialog.showMessage(contents.head, "Norte", "Información")}),
      BorderPanel.Position.North)
    add(new Button(Action("Oeste")
      {Dialog.showMessage(contents.head, "Oeste", "Información")}),
      BorderPanel.Position.West)
    add(new Button(Action("Centro")
      {Dialog.showMessage(contents.head, "Centro", "Información")}),
      BorderPanel.Position.Center)
    add(new Button(Action("Este")
      {Dialog.showMessage(contents.head, "Este", "Información")}),
      BorderPanel.Position.East)
    add(new Button(Action("Sur: Cerrar") { dispose() }), BorderPanel.Position.South)
  }
}
