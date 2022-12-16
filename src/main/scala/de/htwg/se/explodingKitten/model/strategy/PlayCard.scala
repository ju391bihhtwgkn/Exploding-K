package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.model.{Gamestate, Player}

import scala.io.StdIn.readLine

class PlayCard extends Move {

  override def makeMove(state: Gamestate): Gamestate = {
    println("Which Card do you want to play ? Please enter the Number of the Card") //Tui aktivieren
    val cNr = readLine().toInt
    val currentPlayer = state.currentPlayer
    val card = state.players(currentPlayer).chooseCardToPlay(cNr)
    //println("Before playCard \n" + state.players(currentPlayer).handCards)
    //val newHandCards = state.players(currentPlayer).playCard(card)
    //val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
    //val newState = state.copy(players = newPlayer)
    //println("Cards after\n" + state.players(currentPlayer).handCards)
    //val card = person.chooseCardToPlay(cNr)
    //var newPerson = person.playCard(card)
    println("You played: " + card.cardName)

    card.actionCode match {
      case 1 => {
        // Draw from the Bottom
        val newHandCards = state.players(currentPlayer).playCard(card)
        val newPlayerr = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
        val newStatee = state.copy(players = newPlayerr)

        val tempCard = state.deck.last
        println(state.players(state.currentPlayer).name + " you have drawn this card: " + tempCard + "\n")
        val newDeck = state.deck.dropRight(1)

        val newPlayer = newStatee.players.updated(newStatee.currentPlayer, Player(newStatee.players(newStatee.currentPlayer).name
          , newStatee.players(newStatee.currentPlayer).handCards.appended(tempCard)))
        val newState = newStatee.copy(deck = newDeck, players = newPlayer)
        newState
        // TODO: Exploding kitten check
      }
      // See the Future
      case 2 => {
        val newHandCards = state.players(currentPlayer).playCard(card)
        val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
        val newState = state.copy(players = newPlayer)

        if (newState.deck.length > 2) {
          val topCards = newState.deck.take(3)
          println(topCards)
          newState
        } else {
          val topCards = newState.deck.take(newState.deck.length)
          println(topCards)
          newState
        }
      }
      // Skip
      case 3 => {
        val newHandCards = state.players(currentPlayer).playCard(card)
        val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
        val nextPlayerState = state.copy(players = newPlayer)
        if (nextPlayerState.currentPlayer == 0) {
          val nextPlayer = nextPlayerState.currentPlayer + 1
          val newState = state.copy(currentPlayer = nextPlayer )
          newState
        } else if(nextPlayerState.currentPlayer == 1) {
          val nextPlayer = nextPlayerState.currentPlayer + 1
          val newState = state.copy(currentPlayer = nextPlayer)
          newState
        } else {
          val nextPlayer = nextPlayerState.currentPlayer + 1
          val newState = state.copy(currentPlayer = nextPlayer)
          newState
        }
      }
    }
  }
}