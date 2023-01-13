package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.strategy.TakeCard
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
    println("Update !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")

    box.contents.clear()

    box.contents += GuiElements(controller).gridBagPanel
    //println(box.contents)

    //box.contents += GuiElements(controller).handCards

      /*
    box.contents

    println(contents)
    println(box.contents)
    box.contents.clear()
    println(contents)

    box.contents += GuiElements(controller).handCards
    box.contents += GuiElements(controller).deck
    */
      contents = box

  }

  val box = new BoxPanel(Orientation.Horizontal){
    border = BorderFactory.createEmptyBorder(10, 0, 10, 0)
    //minimumSize = new Dimension(550, 500)
    //maximumSize = new Dimension(550, 500)
    //preferredSize = new Dimension(550, 500)
    //resizable = false
  }


  pack()
  //centerOnScreen()
  open()

}