package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.controller.Controller

trait Move {
  def makeMove(person: Player, carddeck: Controller): Player
}
