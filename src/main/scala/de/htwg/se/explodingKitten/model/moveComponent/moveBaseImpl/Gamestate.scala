package de.htwg.se.explodingKitten.model.moveComponent.moveBaseImpl

import de.htwg.se.explodingKitten.model.moveComponent.{Move, gamestateInterface}
import de.htwg.se.explodingKitten.model.cardComponent._
import de.htwg.se.explodingKitten.model.playerComponent.playerImpl.PlayerClass

abstract case class Gamestate(
                               currentPlayer: Int,
                               players: Vector[PlayerClass],
                               deck: Vector[Card],
                               discardPile: Vector[Card],
                    )  extends gamestateInterface{

   def handle(move: Move): Gamestate = {
    move match {
      case nextPlayer => {
        nextPlayer.makeMove(this)
        //nextPlayer()
      }
      case takeCard => {
        takeCard.makeMove(this)
      }
      case playCard => {
        playCard.makeMove(this)
      }
    }
  }
}
