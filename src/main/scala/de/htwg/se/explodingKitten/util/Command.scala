package de.htwg.se.explodingKitten.util

import de.htwg.se.explodingKitten.model.Gamestate

trait Command {
  def doStep(): Gamestate
  def undoStep(): Gamestate
  def redoStep(): Gamestate
}
