package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.ExplodingKitten.controller
import de.htwg.se.explodingKitten.model.{Move, TakeCard}
import de.htwg.se.explodingKitten.util.Command


class SetCommand(strategy: Move, gameContext: GameContext) extends Command {

  override def doStep: Unit = gameContext.setStrategy(strategy)

  override def undoStep: Unit = ""

  override def redoStep: Unit = gameContext.setStrategy(strategy)

}


