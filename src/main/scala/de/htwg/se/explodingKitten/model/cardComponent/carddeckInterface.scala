package de.htwg.se.explodingKitten.model.cardComponent


trait carddeckInterface {
  var deck = Vector[Card]()
  var drawnCards = Vector[Card]()
  def initializeDeck(): Unit
  def shuffle(): Vector[Card]
  def addFeralCat(): Vector[Card]
  def addAttack(): Vector[Card]
  def addTargetedAttack(): Vector[Card]
  def addDrawFromTheBottom(): Vector[Card]
  def addExplodingKitten(): Vector[Card]
  def addSkip(): Vector[Card]
  def addDefuse(): Vector[Card]
  def addSeeTheFuture(): Vector[Card]
  def addCard(card: Card, anz: Int = 1): Vector[Card]
  def reduceTop(): Vector[Card]

}
