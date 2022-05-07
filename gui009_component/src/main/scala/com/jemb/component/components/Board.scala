package com.jemb.component.components

class Board {
  private val grid = Array(0,1,2,
                           0,1,0,
                           0,2,0)
  def apply(x:Int, y:Int):Int = grid(3 * y + x)
}
