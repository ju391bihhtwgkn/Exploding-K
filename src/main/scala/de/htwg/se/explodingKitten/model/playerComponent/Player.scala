package de.htwg.se.explodingKitten.model.playerComponent

import de.htwg.se.explodingKitten.model.cardComponent.Card
import de.htwg.se.explodingKitten.model.playerComponent.playerImpl.PlayerClass
import de.htwg.se.explodingKitten.model.stateComponent._

trait Player {
  var state: State
  def konstruktor(name: String, handCards: Vector[Card]) = PlayerClass(name: String, handCards: Vector[Card])
  def copyKonstruktor(): PlayerClass
  def changeState(stat: State): Unit
  def setHasLost(): Unit
  def takeCard(card: Card): PlayerClass
  def playCard(stelle: Int): PlayerClass
  def playCard(card: Card): Vector[Card]
  def chooseCardToPlay(cardNr: Int): Card
  def toString: String
}
