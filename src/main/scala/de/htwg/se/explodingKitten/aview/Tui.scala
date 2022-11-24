package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.model.{Card, Carddeck}

import de.htwg.se.explodingKitten.util.Observer
import de.htwg.se.explodingKitten.controller.Controller

import scala.util.control.Breaks.break

class Tui(controller: Controller) extends Observer {

  controller.add(this)
  val card = Card("MelonCat")
  val card2 = Card("ExplodingKitten")

  def processInputLine(input: String): Unit = {
    input match {
      case "0" => {
        print("add Card to Deck")
        controller.addCard(card, 2)
        controller.addCard(card2, 1)
      }
      case "1" => {
        print("Draw a card \n")
        print(controller.takeTopCard())
      }
      case "2" => {
        print("Thats the first three Cards\n")
        controller.spy().foreach {print}
      }
      case "3" => {
        print("Draw from the bottom\n")
        print(controller.takeCardBottom())
      }
      case "4" => {
        print("Shuffle deck\n")
        controller.shuffle()
      }
      case "5" => {
        print("Put Card into deck\n")
        controller.hideCardInDeck(card2, 1)
      }
        case _ => {
        print("Spiel beendet\n")
        break
      }
    }
  }

  override def update: Unit = println(controller.deck)
}
