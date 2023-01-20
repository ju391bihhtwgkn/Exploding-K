package de.htwg.se.explodingKitten.model.StrategyComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.Card
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.PlayerComponent.Player

import scala.io.StdIn.readLine

class TakeCard extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {
    // get top card
    val tempCard = state.deck.head
    println(state.players(state.currentPlayer).name + " you have drawn this card: " + tempCard.cardName + "\n")
    // remove top card
    val newDeck = state.deck.drop(1)
    // new state for player
    val newPlayer = state.players.updated(state.currentPlayer, Player(state.players(state.currentPlayer).name
      , state.players(state.currentPlayer).handCards.appended(tempCard)))
    if (tempCard.cardName == Card("ExplodingKitten").cardName) {
      val afterCheckState = checkOnExploding(state.currentPlayer, state)
      if (afterCheckState.players.length == 1) {
        println("Congratulations " + afterCheckState.players(0).name + " you have won the Game")
        System.exit(0)
      }
      return afterCheckState
    }
    val newState = state.copy(deck = newDeck, players = newPlayer)
    newState
  }

  def checkOnExploding(currentPlayer: Int, gameState: Gamestate): Gamestate = {
    for (n <- gameState.players(currentPlayer).handCards) if (n.cardName == Card("Defuse").cardName) {
      flag = true
    }
      if (flag == true) {
        val newHandCards = gameState.players(currentPlayer).playCard(Card("Defuse"))
        val newPlayer = gameState.players.updated(currentPlayer, Player(gameState.players(currentPlayer).name, newHandCards))
        println("Where do you want to put the Exploding Kitten into the deck?")
        println("Choose from " + "1 to " + gameState.deck.length)
        val input = readLine().toInt
        input match {
          case x if (0 <= x && x < gameState.deck.length) =>
            val (front, back) = gameState.deck.splitAt(input)
            val newDeck = front ++ Vector(Card("ExplodingKitten")) ++ back
            val newState = gameState.copy(deck = newDeck, players = newPlayer)
            newState
          case _ => println("Choose a allowed Place")
          gameState
        }
      } else {
        println(gameState.players(currentPlayer).name + " You have lost :(")
        val newPlayers = gameState.players.patch(currentPlayer, Nil, 1)
        val newState = gameState.copy(players = newPlayers)
        println(currentPlayer)
        if (currentPlayer == 2) {
          val nextPlayer = 0
          val finalState = newState.copy(currentPlayer = nextPlayer)
          return finalState
        }
        newState
      }
    }
}

