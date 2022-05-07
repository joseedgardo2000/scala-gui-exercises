package com.jemb.evento.GUI

import scala.swing.{Button, Dimension, MainFrame}

class EventoGUI extends MainFrame {
  title = "Prueba de Evento"
  preferredSize = new Dimension(320,240)
  contents = Button("Presionar") {println("Botón Presionado")}
}
