package com.jemb.menu_panels.GUI

import scala.swing.{Action, BorderPanel, Dimension, GridBagPanel, MainFrame, Menu, MenuBar, MenuItem}

class VentanaPrinGUI extends MainFrame{
  preferredSize = new Dimension(320,220)
  title = "Ventana con Menú"

  menuBar = new MenuBar {
    contents += new Menu("Archivo") {
      contents += new MenuItem(Action("Salir") {
        sys.exit(0)
      })
    }
    contents += new Menu("Paneles") {
      contents += new MenuItem(Action("Flow Panel") {
        val flowPanelGUI = new FlowPanelGUI
        flowPanelGUI.visible = true
      })
      contents += new MenuItem(Action("Border Panel") {
        val borderPanelGUI = new BorderPanelGUI
        borderPanelGUI.visible = true
      })
      contents += new MenuItem(Action("Grid Panel") {
        val gridPanelGUI = new GridPanelGUI
        gridPanelGUI.visible = true
      })
      contents += new MenuItem(Action("GridBag Panel") {
        val gridBagPanelGUI = new GridBagPanelGUI
        gridBagPanelGUI.visible = true
      })
    }

  }
  contents = new BorderPanel {}
}
