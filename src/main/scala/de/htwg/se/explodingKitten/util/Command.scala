package de.htwg.se.explodingKitten.util

import de.htwg.se.explodingKitten.model.GameStateInterface
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.Gamestate

trait Command {
  def doStep(): Unit
  def undoStep(): Unit
  def redoStep(): Unit
}
