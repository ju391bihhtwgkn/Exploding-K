package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.model.strategy.Move
import de.htwg.se.explodingKitten.model.{Card, Carddeck, Gamestate, Player}
import de.htwg.se.explodingKitten.util.{Observable, UndoManager}

class Controller() extends Observable {

  var gameState = Gamestate(0, null, null)
  private val undoManager = new UndoManager
  var statement = ""

  def initializeDeck(): Unit = {
    val deck = Carddeck.initializeDeck()
    gameState = gameState.copy(deck = Carddeck.deck)
  }

  def initializePlayers(players: Vector[Player]): Unit = {
    gameState = gameState.copy(players = players, currentPlayer = 0)
  }

  def doStep(move: Move): Gamestate = {
    undoManager.doStep(new SetCommand(move, this))
    notifyObservers
    this.gameState
  }

  def undo: Unit = {
    undoManager.undoStep
    notifyObservers
  }

  def redo(): Unit = {
    undoManager.redoStep
    notifyObservers
  }

  /*
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
   */
}
