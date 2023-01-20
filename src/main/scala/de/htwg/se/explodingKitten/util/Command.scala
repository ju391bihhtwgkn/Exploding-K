package de.htwg.se.explodingKitten.util

import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateInterface

trait Command {
  def doStep(): Unit
  def undoStep(): Unit
  def redoStep(): Unit
}
