package com.jemb.menu_panels.GUI

import scala.swing.{Action, Alignment, Button, Dialog, GridPanel, Label, Swing, TextField}

class GridPanelGUI extends Dialog{
  title = "Grid Panel GUI"
  modal = true
  contents = new GridPanel(4, 2) {
    contents += new Label("Nombre: ") {this.xAlignment = Alignment.Left}
    contents += new TextField("Juan", columns0 = 10)
    contents += new Label("Apellido Paterno: ")
                    {this.xAlignment = Alignment.Left}
    contents += new TextField("García", columns0 = 10)
    contents += new Label("Apellido Materno: ")
                    {this.xAlignment = Alignment.Left}
    contents += new TextField("López", columns0 = 10)
    contents += Swing.HStrut(5)
    contents += new Button(Action("Cerrar"){dispose()})

    border = Swing.EmptyBorder(10, 10, 10, 10)

  }

}
