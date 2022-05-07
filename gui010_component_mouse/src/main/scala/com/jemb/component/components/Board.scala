package com.jemb.component.components

class Board {
  private var player = 1
  private val grid = Array(0,1,2,
                           0,1,0,
                           0,2,0)

  def apply(x:Int, y:Int):Int = grid(3 * y + x)

  def currentPlayer: Int = player

  def play(x: Int, y: Int) {
    if (this(x, y) == 0) {
      grid(3 * y + x) = player
      player = 3 - player
    }
  }

  def restart() {
    for (i <- 0 until 9)
      grid(i) = 0
    player = 1
  }
}
