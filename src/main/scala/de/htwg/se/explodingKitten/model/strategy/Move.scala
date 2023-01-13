package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.model.{Gamestate, Player}

trait Move {
  def makeMove(state: Gamestate): Gamestate
}
