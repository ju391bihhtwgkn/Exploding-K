package de.htwg.se.explodingKitten.model.moveComponent

import de.htwg.se.explodingKitten.model.moveComponent.moveBaseImpl.Gamestate

trait gamestateInterface {
  def handle(move: Move): Gamestate
}
