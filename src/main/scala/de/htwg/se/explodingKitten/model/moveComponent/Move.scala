package de.htwg.se.explodingKitten.model.moveComponent

import de.htwg.se.explodingKitten.model.moveComponent.moveBaseImpl.Gamestate

trait Move {
  def makeMove(state: Gamestate): Gamestate
}
