package com.jemb.compl01

import com.jemb.compl01.GUI.VentanaGUI
import com.jemb.compl01.solucion.Solver

object Principal {
  def main(args: Array[String]): Unit = {
    println("============= gui008_compl01 =============")
    val solver = new Solver
    val ventanaGUI = new VentanaGUI(solver)
    ventanaGUI.visible = true
    println("============= ============== =============")
  }
}
