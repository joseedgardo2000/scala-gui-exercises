package com.jemb.compl01.solucion

import scala.io.Source.fromFile

class Solver {
  private val ingPals = fromFile("src/main/resources/archivos/ingPals.dat")
                        .getLines().toList
  private val espPals = fromFile("src/main/resources/archivos/espPals.dat")
                        .getLines().toList
  private def matches(pattern:String, word:String):Boolean = {
    if(word.length == pattern.length) {
      for (i <- 0 until word.length) {
        println(s"${pattern(i)} - ${word(i)}")
        if (pattern(i) != '?' && pattern(i) != word(i))
          return false
      }
      true
    } else false
  }

  def findWords(pattern:String, dictNo:Int):List[String] = {
    val words:List[String] = if(dictNo==0) ingPals else espPals
    println(words.isEmpty)
    words.filter(p=>matches(pattern,p))
  }
}
