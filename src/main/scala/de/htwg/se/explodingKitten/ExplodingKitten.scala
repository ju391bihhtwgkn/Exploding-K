package de.htwg.se.explodingKitten

import de.htwg.se.explodingKitten.model.{Card, Carddeck, Player}
import de.htwg.se.explodingKitten.controller.Controller

import scala.io.StdIn.readLine
import scala.util.control.Breaks._
import de.htwg.se.explodingKitten.model.Cards.{cardFromBottom, cat, defuseCard, explCard, lookToFuture}
import status.playingStatus
import strategies.{GameContext, PlayCard, TakeCard, newMove}

import scala.collection.immutable.BitSet.empty.foreach

object ExplodingKitten {

  val controller = new Controller(Carddeck().addCard(cat, 2).addCard(explCard).addCard(cardFromBottom, 2))
  val tui = new Tui(controller)
  controller.notifyObservers

  val context = new GameContext(new newMove)

  def main(args: Array[String]): Unit = {
    var p1 = Player("Wiebke", Vector(cat, cat, defuseCard, cardFromBottom))
    var p2 = Player("Julian", Vector(lookToFuture, cat, cat))
    var p3 = Player("Random", Vector(cat, lookToFuture, defuseCard, cat))

    var players = Vector(p1, p2, p3)
    p1.changeState(new playingStatus(p1))
    var p = Player("", Vector())
    breakable {
      while (true) {
        for (player <- players) {
          var input: String = ""
            input = readLine()
            input match {
              case "t" => {
                context.setStrategy(new TakeCard)
              }
              case "p" => {
                context.setStrategy(new PlayCard)
              }
              case _ => {
                break
              }
            }
            //tui.processInputLine(input)
            p = context.executeStrategy(player, controller)
          player.state.onPlay()
          players = (players :+ p).tail
          players.head.changeState(new playingStatus(players.head))
          print("Nächster Spieler ist " + players.head.name)


        }
      }
    }


  }

  //Karten Anzeigen
  //Karte Ziehen oder Legen
  //1.1 Ziehe
  //1.2 Check ob Exploding
  //1.2.1 Check ob extra leben
  //1.2.1.1 Lege extra Leben
  //1.2.1.1.1 Lege Karte zurück in den Stapel
  //1.2.1.2 Tod, Spieler raus
  //1.3 Nächtser ist dran
  //2.1 Lege
  //2.2 Wähle Karte aus und entferne sie aus den karten
  //2.3 Führe Aktion durch
  //2.3.1 Kann Karte Ziehen, abbruch des Spielzuges, Mischen, Anschauen von Karten, Abwehr(darf man noch mal legen danach) beinhalten
  //2.4 Nächster ist dran
}
