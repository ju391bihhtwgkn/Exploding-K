package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.model.Gamestate

class NextPlayer extends Move {
  override def makeMove(state: Gamestate): Gamestate = {
    val nextPlayer = (state.currentPlayer + 1) % state.players.length
    state.copy(currentPlayer = nextPlayer)
  }
}