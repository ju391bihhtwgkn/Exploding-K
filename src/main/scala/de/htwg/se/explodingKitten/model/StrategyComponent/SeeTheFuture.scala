package de.htwg.se.explodingKitten.model.StrategyComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.PlayerComponent.Player

class SeeTheFuture(i: Int) extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {

    val currentPlayer = state.currentPlayer
    val card = state.players(currentPlayer).handCards(i)
    println("You played: " + card.cardName)
    val newDiscardPile = state.discardPile.appended(card)
    val newHandCards = state.players(currentPlayer).playCard(card)
    val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
    val newState = state.copy(players = newPlayer, discardPile = newDiscardPile)

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
}
