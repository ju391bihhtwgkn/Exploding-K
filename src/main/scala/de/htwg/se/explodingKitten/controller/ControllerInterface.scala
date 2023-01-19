package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.model.GameStateInterface
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Gamestate, Player}
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.Move
import de.htwg.se.explodingKitten.util.{Observable, UndoManager}

trait ControllerInterface extends Observable {
  var gameState : Gamestate
  val undoManager : UndoManager
  var flag : Boolean
  def initializeDeck(): Unit
  def createPlayers(names: List[String]): Unit
  def initializePlayers(players: Vector[Player]): Unit
  def doStep(move: Move): GameStateInterface
  def undo(): Unit
  def redo(): Unit
}
