package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.model.{Card, Carddeck}
import de.htwg.se.explodingKitten.util.Observable

class Controller(var deck: Carddeck) extends Observable {

  def addCard(card: Card, anz: Int): Unit = {
    deck = deck.addCard(card, anz)
    notifyObservers
  }

  def takeTopCard(): Card = {
    val topCard = deck.takeCardTop()
    deck = deck.reduceTop()
    notifyObservers
    topCard
  }

  def reduceTop(): Carddeck = {
    val newdeck = deck.reduceTop()
    notifyObservers
    newdeck
  }

  def spy(): Vector[Card] = {
    val cards = deck.spy()
    notifyObservers
    cards
  }

  def takeCardBottom(): Card = {
    val bottomCard = deck.takeCardBottom()
    deck = deck.reduceBottom()
    notifyObservers
    bottomCard
  }

  def shuffle(): Carddeck = {
    deck = deck.shuffleDeck()
    notifyObservers
    deck
  }

  def hideCardInDeck(card: Card, position: Int): Carddeck = {
    deck = deck.hideCardInDeck(card, position)
    notifyObservers
    deck
  }
}
