package de.htwg.se.explodingKitten

import com.google.inject.Guice
import de.htwg.se.explodingKitten.aview.{Gui, Tui}
import de.htwg.se.explodingKitten.controller.controllerBaseImplementation.Controller
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Card, Carddeck}


object ExplodingKitten {

  val controller = Controller()
  val tui = new Tui(controller)
  val injector = Guice.createInjector(new ExplodingKittenModule)

  def main(args: Array[String]): Unit = {
      val gui =  new Gui(controller)
        while(true) {
          tui.processInputLine()
        }
      }
}
