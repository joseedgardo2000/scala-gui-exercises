package com.jemb.evento

import com.jemb.evento.GUI.EventoGUI

object Principal {
  def main(args: Array[String]): Unit = {
    println("============= gui002_evento =============")
    val eventoGUI = new EventoGUI
    eventoGUI.visible = true
    println("============= ============= =============")
  }
}
