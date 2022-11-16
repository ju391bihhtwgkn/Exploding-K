package de.htwg.se.explodingKitten

import de.htwg.se.explodingKitten.aview.Tui
import de.htwg.se.explodingKitten.model.{Card, Carddeck}
import de.htwg.se.explodingKitten.controller.Controller

import scala.io.StdIn.readLine

object ExplodingKitten {

  val controller = new Controller(Carddeck())
  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = ""

    do {
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")
  }
}
