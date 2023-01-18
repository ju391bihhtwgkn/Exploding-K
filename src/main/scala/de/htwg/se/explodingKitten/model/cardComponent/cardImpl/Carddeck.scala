package de.htwg.se.explodingKitten.model.cardComponent.cardImpl

import de.htwg.se.explodingKitten.model.cardComponent._

import scala.util.Random

object Carddeck extends carddeckInterface{

  override var deck = Vector[Card]()
  override var drawnCards = Vector[Card]()

  def initializeDeck(): Unit = this.deck =
    addSeeTheFuture() ++ addAttack() ++ addSkip() ++ addTargetedAttack() ++ addDrawFromTheBottom() ++ addAttack() ++ addDrawFromTheBottom() ++ addAttack() ++ addTargetedAttack() ++
      addTargetedAttack()

  // TODO: make creation of deck better
  def shuffle(): Vector[Card] = {
    val newDeck = Random.shuffle(deck)
    newDeck
  }

  def addFeralCat(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(3, Cards("FeralCat"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addAttack(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Cards("Attack"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addTargetedAttack(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Cards("TargetedAttack"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addDrawFromTheBottom(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Cards("DrawFromTheBottom"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addExplodingKitten(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(2, Cards("ExplodingKitten"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addSkip(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(1, Cards("Skip"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addDefuse(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(3, Cards("Defuse"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def addSeeTheFuture(): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(2, Cards("SeeTheFuture"))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }



  /*
  def takeCardTop(n: Int): Card = {
    val card = deck.head
    val helpVector = Vector[Card]().padTo(1, card)
    drawnDeck.drawnCards = drawnCards ++ helpVector
    card
  }


   */


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

  override def apply(s: String): Card = Cards.apply(s)
}
