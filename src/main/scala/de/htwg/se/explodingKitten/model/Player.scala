package de.htwg.se.explodingKitten.model

import scala.io.StdIn.readLine

case class Player(name: String, handCards: Vector[Card], hasLost : Boolean = false) {

  def setHasLost(value : Boolean) : Player = Player(name, handCards, value)

  def takeCard(card: Card) : Player = Player(name, handCards :+ card)

  def playCard(stelle : Int) : Player = {
    val idx = stelle -1
    var temp = Vector[Card]()
    temp = handCards.take(idx)
    temp = temp ++ handCards.takeRight(handCards.length - idx -1)
    Player(name, temp)
  }

  def playCard(card : Card) : Player = {
    val idx = handCards.indexOf(card)
    var temp = Vector[Card]()
    temp = handCards.take(idx)
    temp = temp ++ handCards.takeRight(handCards.length - idx - 1)
    Player(name, temp)
  }

  def chooseCardToPlay(cardNr : Int) : Card = {
    val card = handCards.slice(cardNr -1, cardNr)
    card.head
  }

  override def toString: String = name
}
