package de.htwg.se.explodingKitten.controller.ControllerComponent.controllerBaseImplementation

import de.htwg.se.explodingKitten.model.StrategyComponent.Move
import de.htwg.se.explodingKitten.util.Command


class SetCommand(strategy: Move, controller: Controller) extends Command {

  val state = controller.gameState

  override def doStep(): Unit = {
    val newState = controller.gameState.handle(strategy)
    controller.gameState = newState
    //state
  }

  override def undoStep(): Unit = {
    controller.gameState = state
    //controller.gameState
  }

  override def redoStep(): Unit = {
    val newState = controller.gameState.handle(strategy)
    controller.gameState = newState
    //state
  }
}