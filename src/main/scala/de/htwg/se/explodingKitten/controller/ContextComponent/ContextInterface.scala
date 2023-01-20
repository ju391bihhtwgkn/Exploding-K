package de.htwg.se.explodingKitten.controller.ContextComponent

import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateInterface
import de.htwg.se.explodingKitten.model.StrategyComponent.Move

trait ContextInterface {
  def setStrategy(strat: Move): Unit
  def executeStrategy(controller: ControllerInterface): GameStateInterface
}
