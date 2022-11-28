package strategies

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.{Card, Player}


trait Move {
  def makeMove(person: Player, carddeck: Controller): Player
}
