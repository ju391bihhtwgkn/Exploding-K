package de.htwg.se.explodingKitten.controller.ControllerComponent.controllerBaseImplementation

import com.google.inject.{Guice, Inject}
import de.htwg.se.explodingKitten.ExplodingKittenModule
import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface
import de.htwg.se.explodingKitten.model.FileIOComponent.FileIOInterface
import de.htwg.se.explodingKitten.model.GameStateComponent.{Card, CardDeck}
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateInterface
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.Move
import de.htwg.se.explodingKitten.util.{Observable, UndoManager}

import scala.util.Random

case class Controller@Inject()(var gameState: GameStateInterface) extends ControllerInterface with Observable {

  val undoManager = new UndoManager
  var flag = false

  def initializeDeck(): Unit = {
    CardDeck.initializeDeck()
    val shuffledDeck = CardDeck.deck
    gameState = Gamestate(0, Vector[Player](), deck = shuffledDeck, Vector(Card("FeralCat")))
  }

  def createPlayers(names: List[String]): Unit = {
    gameState = Gamestate(currentPlayer = gameState.currentPlayer, players = (0 until 3).map(m =>Player(names.apply(m), CardDeck.deck.take(4))).toVector,
      deck = gameState.deck, discardPile = gameState.discardPile)
  }

  def initializePlayers(players: Vector[Player]): Unit = {
    gameState = Gamestate(currentPlayer = 0, players = gameState.players, deck = gameState.deck, discardPile = gameState.discardPile)
    flag = true
    notifyObservers()
  }

  def doStep(move: Move): GameStateInterface = {
    undoManager.doStep(new SetCommand(move, this))
    notifyObservers()
    this.gameState
  }

  def undo(): Unit = {
    undoManager.undoStep
    notifyObservers()
  }

  def redo(): Unit = {
    undoManager.redoStep
    notifyObservers()
  }

  def save(): Unit = {
    def fileIO = Guice.createInjector(new ExplodingKittenModule).getInstance(classOf[FileIOInterface])
    fileIO.save(gameState)
    notifyObservers()
  }

  def load(): Unit = {
    def fileIO = Guice.createInjector(new ExplodingKittenModule).getInstance(classOf[FileIOInterface])
    gameState = fileIO.load
    notifyObservers()
  }

}
