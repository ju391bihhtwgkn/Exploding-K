package de.htwg.se.explodingKitten.model

import scala.util.Random

object Carddeck {

    var deck = Vector[Card]()
    var drawnCards = Vector[Card]()


  def initializeDeck(): Unit = this.deck = addFeralCat() ++ addExplodingKitten() ++ addDrawFromTheBottom()

  // TODO: make creation of deck better

  def addFeralCat(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(2, Card("FeralCat"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addDrawFromTheBottom(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(2, Card("DrawFromTheBottom"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addExplodingKitten(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(2, Card("ExplodingKitten"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }


  def addCard(card: Card, anz: Int = 1): Vector[Card] = {
    //val newdeck : Vector[Card] = deck
    val helpVector = Vector[Card]().padTo(anz, card)
    val newdeck = deck ++ helpVector
    newdeck
  }

  def reduceTop(): Vector[Card] = {
    //val newdeck: Vector[Card] = deck
    val newdeck = deck.tail
    newdeck
  }



  /*
    def addCard(card: Card, anz: Int = 1): Vector[Card] = {
      val newDeck = deck
      val helpVector = Vector[Card]().padTo(anz, card)
      deck ++ helpVector
    }

   */
/*
  def takeCardTop(): Card = {
    val drawnDeck : Carddeck = Carddeck()
    val card = deck.head
    val helpVector = Vector[Card]().padTo(1, card)
    drawnDeck.drawnCards = drawnCards ++ helpVector
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

  def len() : Int = deck.length

 */
}
