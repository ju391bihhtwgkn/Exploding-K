package de.htwg.se.explodingKitten.controller.controllerBaseImplementation

import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.Gamestate
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.Move
import de.htwg.se.explodingKitten.util.Command


class SetCommand(strategy: Move, controller: Controller) extends Command {

  val state: Gamestate = controller.gameState

  override def doStep(): Gamestate = {
    val newState = controller.gameState.handle(strategy)
    controller.gameState = newState
    state
  }

  override def undoStep(): Gamestate = {
    controller.gameState = state
    controller.gameState
  }

  override def redoStep(): Gamestate = {
    val newState = controller.gameState.handle(strategy)
    controller.gameState = newState
    state
  }
}