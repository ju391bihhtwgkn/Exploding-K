package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.{Controller, GameContext}
import de.htwg.se.explodingKitten.model.{Card, Player, newMove, playingStatus}
import de.htwg.se.explodingKitten.util.Observer

import scala.io.StdIn.readLine
import scala.util.control.Breaks.{break, breakable}

class Tui(controller: Controller) extends Observer {

  controller.add(this)

  var p1 = Player("Wiebke", Vector(Card("FeralCat"), Card("FeralCat"), Card("Defuse"), Card("DrawFromTheBottom")))
  var p2 = Player("Julian", Vector(Card("SeeTheFuture"), Card("FeralCat"), Card("FeralCat")))
  var p3 = Player("Random", Vector(Card("FeralCat"), Card("SeeTheFuture"), Card("Defuse"), Card("FeralCat")))

  var players = Vector(p1, p2, p3)
  p1.changeState(new playingStatus(p1))
  var p = Player("", Vector())

  val context = new GameContext(new newMove)

  def processInputLine(): Unit = {
    breakable {
      while(true) {
        for (player <- players) {
          println("Your turn! " + player + "\n")
          println("These are you Cards\n" + player.handCards)
          var input: String = ""
          input = readLine()
          input match {
            case "t" => {
              context.takeCard(context)
            }
            case "p" => {
              context.playCard(context)
            }
            case "u" => {
              context.undo
            }
            case "r" => {
              context.redo
            }
            case _ => {
              break
            }
          }
              p = context.executeStrategy(player, controller)
              p.state.onPlay()
              players = (players :+ p).tail
              players.head.changeState(new playingStatus(players.head))
              //print("Nächster Spieler ist " + players.head.name)
        }
      }
    }


      /*

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

     */
    }
  override def update: Unit = controller.deck
}
