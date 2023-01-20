package de.htwg.se.explodingKitten.model.StrategyComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate

trait Move {
  def makeMove(state: Gamestate): Gamestate
}
