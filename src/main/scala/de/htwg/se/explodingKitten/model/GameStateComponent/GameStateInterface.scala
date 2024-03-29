package de.htwg.se.explodingKitten.model.GameStateComponent

import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.Move

trait GameStateInterface {

  val currentPlayer: Int
  val players: Vector[Player]
  val deck: Vector[Card]
  val discardPile: Vector[Card]

  def handle(move: Move): GameStateInterface
}
