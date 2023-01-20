package de.htwg.se.explodingKitten.model.GamestateBaseImplementation

import scala.util.Random

object Carddeck {

  var deck = Vector[Card]()
  var drawnCards = Vector[Card]()

  def initializeDeck(): Unit = this.deck =
    addAttack() ++ addShuffle() ++ addTargetedAttack() ++ addDrawFromTheBottom() ++ addExplodingKitten() ++ addDrawFromTheBottom() ++ addAttack() ++ addTargetedAttack() ++
      addTargetedAttack()

  def shuffle(): Vector[Card] = {
    val newDeck = Random.shuffle(deck)
    newDeck
  }

  def addShuffle(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(3, Card("Shuffle"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }


  def addFeralCat(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(3, Card("FeralCat"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addAttack(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Card("Attack"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addTargetedAttack(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Card("TargetedAttack"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addDrawFromTheBottom(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Card("DrawFromTheBottom"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addExplodingKitten(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(2, Card("ExplodingKitten"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addSkip(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Card("Skip"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addDefuse(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(3, Card("Defuse"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addSeeTheFuture(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(2, Card("SeeTheFuture"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addCard(card: Card, anz: Int = 1): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(anz, card)
    val newdeck = deck ++ helpVector
    newdeck
  }

  def reduceTop(): Vector[Card] = {
    val newdeck = deck.tail
    newdeck
  }
}
