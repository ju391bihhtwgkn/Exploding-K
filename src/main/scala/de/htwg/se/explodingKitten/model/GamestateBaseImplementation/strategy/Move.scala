package de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy

import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.Gamestate

trait Move {
  def makeMove(state: Gamestate): Gamestate
}