package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.model.{Move, PlayCard, Player, TakeCard}
import de.htwg.se.explodingKitten.util.{Observable, UndoManager}

class GameContext(var strategy: Move) extends Observable {

  private val undoManager = new UndoManager

  def setStrategy(strat : Move) : Unit = strategy = strat

  def executeStrategy(person : Player, carddeck : Controller): Player =
   return strategy.makeMove(person, carddeck)

  def takeCard(context: GameContext): Unit = {
    undoManager.doStep(new SetCommand(new TakeCard, context))
  }

  def playCard(context: GameContext): Unit = {
    undoManager.doStep(new SetCommand(new PlayCard, context))
  }

  def undo: Unit = {
    undoManager.undoStep
    notifyObservers
  }

  def redo: Unit = {
    undoManager.redoStep
    notifyObservers
  }
}
