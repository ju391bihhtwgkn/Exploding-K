package status

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.{Card, Player}

abstract class State (player : Player){
  def onLock()
  def onPlay()

}
