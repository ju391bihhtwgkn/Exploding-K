package de.htwg.se.explodingKitten.model.PlayerComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.Card

case class Player(name: String, handCards: Vector[Card]) {

  def playCard(card: Card): Vector[Card] = {
    val idx = handCards.indexOf(card)
    var temp = Vector[Card]()
    temp = handCards.take(idx)
    temp = temp ++ handCards.takeRight(handCards.length - idx - 1)
    temp
  }

  override def toString: String = name
}
