package de.htwg.se.explodingKitten.model.GamestateBaseImplementation

import de.htwg.se.explodingKitten.model.GameStateInterface
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.Move

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
      case playCard => playCard.makeMove(this)
    }
  }
}
