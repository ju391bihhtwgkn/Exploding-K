package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.{Gamestate, Player}

trait Move {

  def makeMove(state: Gamestate): Gamestate
  //def nextPlayer(state: Gamestate): Gamestate
  //def nextPlayer(state: Gamestate): Gamestate
  //def nextPlayer(state: Gamestate): Gamestate
  //def takeCard(state: Gamestate): Gamestate
}
