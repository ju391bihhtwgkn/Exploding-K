package de.htwg.se.explodingKitten.controller.controllerBaseImplementation

import com.google.inject.Inject
import de.htwg.se.explodingKitten.controller.ControllerInterface
import de.htwg.se.explodingKitten.model.GameStateInterface
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Card, Carddeck, Gamestate}
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.Move
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.util.{Observable, UndoManager}

case class Controller@Inject()() extends ControllerInterface with Observable {

  var gameState = Gamestate(0, Vector[Player](), Vector[Card](), Vector(Card("FeralCat")))
  val undoManager = new UndoManager
  var flag = false

  def initializeDeck(): Unit = {
    val deck = Carddeck.initializeDeck()
    gameState = gameState.copy(deck = Carddeck.deck)
    //gamestate = gamestate.deck = Carddeck.deck
  }

  def createPlayers(names: List[String]): Unit = {
    gameState = gameState.copy(players = (0 until 3).map(m =>Player(names.apply(m), Carddeck.deck.take(4))).toVector)
  }

  def initializePlayers(players: Vector[Player]): Unit = {
    gameState = gameState.copy(players = players, currentPlayer = 0)
    flag = true
    notifyObservers
  }

  def doStep(move: Move): GameStateInterface = {
    undoManager.doStep(new SetCommand(move, this))
    notifyObservers
    this.gameState
  }

  def undo(): Unit = {
    undoManager.undoStep
    notifyObservers
  }

  def redo(): Unit = {
    undoManager.redoStep
    notifyObservers
  }
}
