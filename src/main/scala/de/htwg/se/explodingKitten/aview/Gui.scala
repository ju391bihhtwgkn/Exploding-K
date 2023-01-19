package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.util.Observer

import javax.swing.BorderFactory
import scala.swing._

class Gui(controller: Controller) extends MainFrame with Observer {
  controller.add(this)
  title = "Exploding Kitten"

  contents = createGame(controller).start

  override def update: Unit = {
    box.contents.clear()
    box.contents += GuiElements(controller).gridBagPanel
      contents = box
  }

  val box = new BoxPanel(Orientation.Horizontal){
    border = BorderFactory.createEmptyBorder(10, 0, 10, 0)
    preferredSize = new Dimension(1600, 900)
  }
  open()
}