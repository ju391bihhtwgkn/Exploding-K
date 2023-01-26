package de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation

import de.htwg.se.explodingKitten.model.GameStateComponent.{Card, GameStateInterface}
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.Move

case class Gamestate(
                      currentPlayer: Int,
                      players: Vector[Player],
                      deck: Vector[Card],
                      discardPile: Vector[Card],
                    ) extends GameStateInterface {

  def handle(move: Move): Gamestate = {
    move match {
      case nextPlayer => nextPlayer.makeMove(this)
      case takeCard => takeCard.makeMove(this)
    }
  }
}