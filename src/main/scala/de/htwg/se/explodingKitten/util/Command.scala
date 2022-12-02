package de.htwg.se.explodingKitten.util

trait Command {

  def doStep: Unit
  def undoStep: Unit
  def redoStep: Unit
}
