package com.jemb.hola_mundo.GUI

import scala.swing.{Dimension, Label, MainFrame}

class HolaMundoUI extends MainFrame{
  title = "GUI Hola Mundo"
  preferredSize = new Dimension(320,320)
  contents = new Label("¡¡¡¡Hola Mundo!!!!")
}
