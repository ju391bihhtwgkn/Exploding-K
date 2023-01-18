package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.moveComponent.moveBaseImpl.TakeCard
import de.htwg.se.explodingKitten.util.Observer

import javax.swing.BorderFactory
import scala.swing._

class Gui(controller: Controller) extends MainFrame with Observer {
  controller.add(this)
  title = "Exploding Kitten"

  contents = createGame(controller).start
  //val b = GuiElements(controller).deck
  //val a = GuiElements(controller).handCards
  //var c = GuiElements(controller).gridBagPanel

  override def update: Unit = {
    box.contents.clear()
    box.contents += GuiElements(controller).gridBagPanel
      contents = box
  }

  val box = new BoxPanel(Orientation.Horizontal){
    border = BorderFactory.createEmptyBorder(10, 0, 10, 0)
    //preferredSize = new Dimension(1600, 800)
  }
  open()
}