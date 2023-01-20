package de.htwg.se.explodingKitten.model.StrategyComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.PlayerComponent.Player

class Skip(i: Int) extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {

    val currentPlayer = state.currentPlayer
    val card = state.players(currentPlayer).handCards(i)
    val newHandCards = state.players(currentPlayer).playCard(card)
    val newDiscardPile = state.discardPile.appended(card)
    val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
    val nextPlayerState = state.copy(players = newPlayer, discardPile = newDiscardPile)

    if (nextPlayerState.currentPlayer == 0) {
      val nextPlayer = nextPlayerState.currentPlayer + 1
      val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
      newState
    } else if (nextPlayerState.currentPlayer == 1 && nextPlayerState.players.length == 3) {
      val nextPlayer = nextPlayerState.currentPlayer + 1
      val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
      newState
    } else if (nextPlayerState.currentPlayer == 1 && nextPlayerState.players.length == 2) {
      val nextPlayer = nextPlayerState.currentPlayer - 1
      val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
      newState
    } else {
      val nextPlayer = nextPlayerState.currentPlayer - 2
      val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
      newState
    }
  }
}