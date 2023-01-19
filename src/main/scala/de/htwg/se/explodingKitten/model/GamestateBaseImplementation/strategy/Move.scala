package de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy

import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Gamestate, Player}

trait Move {
  def makeMove(state: Gamestate): Gamestate
}
