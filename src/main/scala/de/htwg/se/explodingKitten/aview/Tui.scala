package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.{Controller, GameContext}
import de.htwg.se.explodingKitten.model.strategy
import de.htwg.se.explodingKitten.model.strategy.{NextPlayer, PlayCard, TakeCard}
//import de.htwg.se.explodingKitten.model.strategy.{PlayCard, TakeCard, newMove}
import de.htwg.se.explodingKitten.model.{Card, Player, playingStatus}
import de.htwg.se.explodingKitten.util.Observer

import scala.io.StdIn.readLine

class Tui(controller: Controller) extends Observer {

  controller.add(this)

  var p1 = Player("Wiebke", Vector(Card("FeralCat"), Card("FeralCat"), Card("Defuse"), Card("DrawFromTheBottom")))
  var p2 = Player("Julian", Vector(Card("Skip"), Card("SeeTheFuture"), Card("FeralCat"), Card("FeralCat")))
  var p3 = Player("Random", Vector(Card("FeralCat"), Card("SeeTheFuture"), Card("Defuse"), Card("FeralCat")))

  var players = Vector(p1, p2, p3)
  p1.changeState(new playingStatus(p1))
  var p = Player("", Vector())

  val context = new GameContext(null)
  controller.initializeDeck()
  controller.initializePlayers(players)


  //println(controller.gameState.players)
  //println(controller.gameState.currentPlayer)
  //println(controller.gameState.deck)

  def processInputLine(): Unit = {
    println(controller.gameState.currentPlayer)
    println("Your turn " + controller.gameState.players(controller.gameState.currentPlayer).name)
    println(controller.gameState.players(controller.gameState.currentPlayer).handCards.toString())
    val input = readLine()
    input match {
      case "t" => {
        // Take a Card
        context.setStrategy(new TakeCard())
        context.executeStrategy(controller)
        // Next Player
        context.setStrategy(new NextPlayer())
        context.executeStrategy(controller)
      }
      case "p" => {
        // Play a Card
        context.setStrategy(new PlayCard())
        context.executeStrategy(controller)
      }
      case "r" => {
        controller.redo()
      }
      case "u" => {
        controller.undo
      }
    }
    }

  override def update: Unit = controller.gameState
}
