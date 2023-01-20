package de.htwg.se.explodingKitten.controller.controllerBaseImplementation

import de.htwg.se.explodingKitten.controller.ControllerInterface
import de.htwg.se.explodingKitten.model.GameStateInterface
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.Gamestate
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.Move
import de.htwg.se.explodingKitten.util.Observable

class GameContext(var strategy: Move) extends Observable {

  def setStrategy(strat : Move) : Unit = strategy = strat

  def executeStrategy(controller: ControllerInterface): GameStateInterface = {
    controller.doStep(strategy)
  }
}
