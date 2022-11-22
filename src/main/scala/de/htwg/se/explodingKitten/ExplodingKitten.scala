package de.htwg.se.explodingKitten

import de.htwg.se.explodingKitten.aview.Tui
import de.htwg.se.explodingKitten.model.{Card, Carddeck, Player}
import de.htwg.se.explodingKitten.controller.Controller
import strategies.Game.{GameContext, PlayCard, TakeCard}

import scala.io.StdIn.readLine
import scala.util.control.Breaks.break
import de.htwg.se.explodingKitten.model.Cards.{cardFromBottom, cat, defuseCard, explCard, lookToFuture}

object ExplodingKitten {

  val controller = new Controller(Carddeck().addCard(cat, 2).addCard(explCard).addCard(cardFromBottom, 2))
  val tui = new Tui(controller)
  controller.notifyObservers

  val context = new GameContext(new TakeCard)

  def main(args: Array[String]): Unit = {
    val p1 = Player("Wiebke", Vector(cat, cat, defuseCard))
    val p2 = Player("Julian", Vector(lookToFuture, cat, cat))


    var input: String = ""



    do {
      input = readLine()
      input match {
        case "t" =>{
          context.setStrategy(new TakeCard)
        }
        case "p" => {
          context.setStrategy(new PlayCard)
        }
        case _ =>{
          break
        }
      }
      //tui.processInputLine(input)
      context.executeStrategy(p1, controller)
    } while (input != "q")
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
