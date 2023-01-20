package de.htwg.se.explodingKitten.controller.ContextComponent.contextBaseimplementation

import de.htwg.se.explodingKitten.controller.ContextComponent.ContextInterface
import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateInterface
import de.htwg.se.explodingKitten.model.StrategyComponent.Move
import de.htwg.se.explodingKitten.util.Observable

case class GameContext(var strategy: Move) extends ContextInterface with Observable {

  def setStrategy(strat : Move) : Unit = strategy = strat

  def executeStrategy(controller: ControllerInterface): GameStateInterface = {
    controller.doStep(strategy)
  }
}