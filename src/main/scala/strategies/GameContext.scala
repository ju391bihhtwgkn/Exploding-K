package strategies

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.{Card, Player}

class GameContext(var strategy: Move) {

  def setStrategy(strat : Move) : Unit = strategy = strat

  def executeStrategy(person : Player, carddeck : Controller): Player =
   return strategy.makeMove(person, carddeck)

}
