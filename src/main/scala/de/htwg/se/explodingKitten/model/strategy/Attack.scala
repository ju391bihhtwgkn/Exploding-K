package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.model.{Gamestate, Player}

class Attack(i: Int) extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {

    val currentPlayer = state.currentPlayer
    val card = state.players(currentPlayer).handCards(i)
    println("You played: " + card.cardName)
    val newDiscardPile = state.discardPile.appended(card)
    val newHandCards = state.players(currentPlayer).playCard(card)
    val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
    val nextPlayerState = state.copy(players = newPlayer, discardPile = newDiscardPile)
    println(nextPlayerState.discardPile)
    if (nextPlayerState.currentPlayer == 0) {
      val nextPlayer = nextPlayerState.currentPlayer + 1
      println(nextPlayer)
      val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
      newState
    } else if (nextPlayerState.currentPlayer == 1) {
      val nextPlayer = nextPlayerState.currentPlayer + 1
      val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
      newState
    } else {
      val nextPlayer = nextPlayerState.currentPlayer - 2
      val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
      newState
    }
  }
}