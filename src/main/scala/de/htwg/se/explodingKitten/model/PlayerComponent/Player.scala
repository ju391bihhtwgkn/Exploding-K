package de.htwg.se.explodingKitten.model.PlayerComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.Card

import scala.util.control.Breaks._

case class Player(name: String, handCards: Vector[Card]) {

  def playCard(card: Card): Vector[Card] = {
    var idx = -1
    var runningidx = 0
    breakable {
      for (i <- handCards) {
        if (i.cardName == card.cardName) {
          idx = runningidx
            break
        }
        runningidx += 1
      }
    }
    var temp = Vector[Card]()
    temp = handCards.take(idx)
    temp = temp ++ handCards.takeRight(handCards.length - idx - 1)
    temp
  }

  def chooseCardToPlay(cardNr: Int): Card = {
    val card = handCards.slice(cardNr - 1, cardNr)
    card.head
  }

  override def toString: String = name
}
