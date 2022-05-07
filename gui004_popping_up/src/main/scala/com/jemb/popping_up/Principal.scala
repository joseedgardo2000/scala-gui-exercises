package com.jemb.popping_up

import com.jemb.popping_up.GUI.Ventana

object Principal {
  def main(args: Array[String]): Unit = {
    println("============= gui004_popping_up =============")
    val ventana = new Ventana
    ventana.visible = true
    println("============= ================= =============")
  }
}
