package de.htwg.se.explodingKitten

import com.google.inject.Guice
import de.htwg.se.explodingKitten.aview.{Gui, Tui}
import de.htwg.se.explodingKitten.controller.ContextComponent.ContextInterface
import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface

object ExplodingKitten {

  val injector = Guice.createInjector(new ExplodingKittenModule)
  val controller = injector.getInstance(classOf[ControllerInterface])
  val context = injector.getInstance(classOf[ContextInterface])

  val tui = new Tui(controller,context)

  def main(args: Array[String]): Unit = {
    val gui =  new Gui(controller, context)
      while(true) {
        tui.processInputLine()
      }
  }
}
