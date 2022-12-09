package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.controller.{Controller, GameContext}

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}
import scala.util.control.Breaks.{break, breakable}

class PlayCard extends Move {
  override def makeMove(person: Player, carddeck: Controller): Player = {
    var inputB = true
    var cNr = 0
    while(inputB) {
      print("Welche Karte wollen Sie spielen? Geben Sie die PlatzNr. der Karte ein:") //Tui aktivieren
      val s = readLine()
      toInt(s) match {
        case None => inputB = true
        case _ => {
          inputB = false
          cNr = toInt(s).get
        }
      }
    }

    val card = person.chooseCardToPlay(cNr)
    var newPerson = person.playCard(card)
    card.actionCode match {
      case 2 => {
        carddeck.spy()
        newPerson
      }
      case 4 => {
        val context = new GameContext(new TakeCard)
        carddeck.deck.deck = carddeck.deck.deck.reverse
        newPerson = context.executeStrategy(newPerson, carddeck)
        carddeck.deck.deck = carddeck.deck.deck.reverse
        newPerson
      }
      case _ => {
        newPerson
      }
    }
  }

  def toInt(s : String) : Option[Int] = {
      Try(s.toInt) match{
        case Success(value) => return Some(s.toInt)
        case Failure(exception) => return None
      }
  }
}
