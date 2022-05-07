package com.jemb.hola_mundo

import com.jemb.hola_mundo.GUI.HolaMundoUI

object Principal {
  def main(args: Array[String]): Unit = {
    println("============= gui001_hola_mundo =============")
    val hmGui = new HolaMundoUI
    hmGui.visible = true
    println("============= ================= =============")
  }
}
