package de.htwg.se.explodingKitten.model.moveComponent.moveBaseImpl

import de.htwg.se.explodingKitten.model.moveComponent.Move

class NextPlayer extends Move {
  override def makeMove(state: Gamestate): Gamestate = {
    val nextPlayer = (state.currentPlayer + 1) % state.players.length
    state.copy(currentPlayer = nextPlayer)
  }
}