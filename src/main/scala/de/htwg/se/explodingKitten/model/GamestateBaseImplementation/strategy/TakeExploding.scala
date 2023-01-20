package de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy

import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.Carddeck.deck
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Card, Gamestate}
import de.htwg.se.explodingKitten.model.PlayerComponent.Player

class TakeExploding(i : Int) extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {
    val currentPlayer = state.currentPlayer

    // Remove Exploding Kitten from Deck
    val newDeck = state.deck.drop(1)
    println(state.players(currentPlayer).name + " you have drawn a " + Card("ExplodingKitten").cardName + "\n")

    // Check for Defuse Card
    for (n <- state.players(currentPlayer).handCards) if (n.cardName == Card("Defuse").cardName) flag = true

    val idx = state.players(currentPlayer).handCards.indexWhere(Card => Card.cardName == "Defuse")

    if(flag == true) {
      // remove Defuse Card from PlayerHand
      val card = state.players(currentPlayer).handCards(idx)
      println(state.players(state.currentPlayer))
      val newHandCards = state.players(state.currentPlayer).playCard(card)
      val newPlayers = state.players.updated(currentPlayer, Player(state.players(state.currentPlayer).name
        , newHandCards))
      val newState = state.copy(deck = newDeck, players = newPlayers)

      // put Exploding Kitten back into Deck
      if (0 < i && i <= newState.deck.length) {
        val (front, back) = newState.deck.splitAt(i)
        val newDeck = front ++ Vector(Card("ExplodingKitten")) ++ back
        val newState2 = newState.copy(deck = newDeck)
        newState2
    } else {
        println("invalid Number")
        state
      }
  } else {
      println(state.players(currentPlayer).name + "You have lost :(")
      val newPlayers = state.players.patch(currentPlayer, Nil, 1)
      val newState = state.copy(players = newPlayers, currentPlayer = currentPlayer - 1)
      newState
    }
  }
}




    /*

    val currentPlayer = state.currentPlayer
    // get top card
    val tempCard = state.deck.head
    println(state.players(currentPlayer).name + " you have drawn this card: " + tempCard.cardName + "\n")
    // remove top card
    val newDeck = state.deck.drop(1)
    // new state for player
    val newPlayer = state.players.updated(currentPlayer, Player(state.players(state.currentPlayer).name
      , state.players(currentPlayer).handCards))

      val afterCheckState = checkOnExploding(state.currentPlayer, state)
      if (afterCheckState.players.length == 1) {
        println("Congratulations " + afterCheckState.players(0).name + " you have won the Game")
        System.exit(0)
      }
      return afterCheckState
  }

  def checkOnExploding(currentPlayer: Int, gameState: Gamestate): Gamestate = {
    for (n <- gameState.players(currentPlayer).handCards) if (n.cardName == Card("Defuse").cardName) {
      flag = true
    }
    if (flag == true) {
      println("BEfore")
      println(gameState.players(currentPlayer).handCards)
      val newHandCards = gameState.players(currentPlayer).playCard(Card("Defuse"))
      println("after")
      println(newHandCards)
      val newPlayer = gameState.players.updated(currentPlayer, Player(gameState.players(currentPlayer).name, newHandCards))
        if (0 < i && i < gameState.deck.length) {
          val (front, back) = gameState.deck.splitAt(i)
          val newDeck = front ++ Vector(Card("ExplodingKitten")) ++ back
          val newState = gameState.copy(deck = newDeck, players = newPlayer)
          println("--------------------")
          println(newState.players(currentPlayer).handCards)
          newState
        } else {
          println("Invalid number")
          gameState
        }
    } else {
      gameState.players(gameState.currentPlayer).setHasLost()
      println(gameState.players(currentPlayer).name + "You have lost :(")
      val newPlayers = gameState.players.patch(currentPlayer, Nil, 1)
      val newState = gameState.copy(players = newPlayers)
      println(newState.players)
      newState
    }
  }
}

*/