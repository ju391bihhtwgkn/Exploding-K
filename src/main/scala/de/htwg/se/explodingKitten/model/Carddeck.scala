package de.htwg.se.explodingKitten.model

import scala.util.Random

case class Carddeck() {

    var deck = Vector[Card]()

  def addCard(card: Card, anz: Int = 1): Carddeck = {
    val newdeck : Carddeck = Carddeck()
    val helpVector = Vector[Card]().padTo(anz, card)
    newdeck.deck = deck ++ helpVector
    newdeck
  }

  def takeCardTop(): Card = {
    val card = deck.head
    card
  }

  def reduceTop(): Carddeck = {
    val newdeck: Carddeck = Carddeck()
    newdeck.deck = deck.tail
    newdeck
  }

  def spy(): Vector[Card] = {
    if (deck.length > 2) deck.take(3)
    else
      deck.take(deck.length)
  }

  def takeCardBottom(): Card = {
    deck.last
  }

  def reduceBottom(): Carddeck = {
    val newdeck: Carddeck = Carddeck()
    newdeck.deck = deck.init
    newdeck
  }

  def shuffleDeck(): Carddeck = {
    val l = deck.indices.toList
    val shuf = Random.shuffle(l)
    var newCardDeck: Carddeck = Carddeck()
    shuf.foreach(x => newCardDeck = newCardDeck.addCard(deck(x)))
    shuf.foreach{print}
    newCardDeck
  }

  def hideCardInDeck(card: Card, position: Int): Carddeck = {
    val newDeck: Carddeck = Carddeck()
    newDeck.deck = deck.take(position - 1)
    newDeck.deck = newDeck.deck :+ card
    if (position == 0) newDeck.deck = newDeck.deck ++ this.deck.take(deck.length)
    else newDeck.deck = newDeck.deck ++ this.deck.take(deck.length - (position - 1))
    newDeck
  }
}
