package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.model.strategy.Move
import de.htwg.se.explodingKitten.model.{Gamestate}
import de.htwg.se.explodingKitten.util.{Observable, UndoManager}

class GameContext(var strategy: Move) extends Observable {

  def setStrategy(strat : Move) : Unit = strategy = strat

  def executeStrategy(controller: Controller): Gamestate = {
    controller.doStep(strategy)
  }
}
