package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.controller.{Controller, GameContext}
import de.htwg.se.explodingKitten.model.{Gamestate, Player}

import scala.io.StdIn.readLine

/*
class PlayCard extends Move {
  override def makeMove(person: Player, carddeck: Controller): Player = {
    println("Which Card do you want to play ? Please enter the Number of the Card") //Tui aktivieren
    val cNr = readLine().toInt
    val card = person.chooseCardToPlay(cNr)
    var newPerson = person.playCard(card)
    println("You played: " + card.cardName)
    //print(newPerson.handCards)
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

  override def nextPlayer(state: Gamestate): Gamestate = null
}


 */