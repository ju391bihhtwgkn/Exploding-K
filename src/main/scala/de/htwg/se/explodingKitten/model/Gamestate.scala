package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.strategy.{Move}

case class Gamestate(
                    currentPlayer:Int,
                    players:Vector[Player],
                    deck: Vector[Card],
                    discardPile: Vector[Card],
                    ){

  def handle(move: Move): Gamestate = {
    move match {
      case  nextPlayer  => {
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