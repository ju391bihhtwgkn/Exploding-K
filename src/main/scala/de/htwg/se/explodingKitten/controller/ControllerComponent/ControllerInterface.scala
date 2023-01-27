package de.htwg.se.explodingKitten.controller.ControllerComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateInterface
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.Move
import de.htwg.se.explodingKitten.util.{Observable, UndoManager}

trait ControllerInterface extends Observable {
  var gameState: GameStateInterface

  def undoManager: UndoManager

  def flag: Boolean

  def initializeDeck(): Unit

  def createPlayers(names: List[String]): Unit

  def initializePlayers(players: Vector[Player]): Unit

  def doStep(move: Move): GameStateInterface

  def undo(): Unit

  def redo(): Unit

  def load(): Unit

  def save(): Unit
}
