package com.jemb.component

import com.jemb.component.GUI.VentanaGUI
import com.jemb.component.components.Board

object Principal {
  def main(args: Array[String]): Unit = {
    println("============= gui009_component =============")
    val board = new Board
    val ventanaGUI = new VentanaGUI(board)
    ventanaGUI.visible = true
    println("============= ================ =============")
  }
}
