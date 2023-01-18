package de.htwg.se.explodingKitten.model.stateComponent.stateImpl

import de.htwg.se.explodingKitten.model.playerComponent.playerImpl.PlayerClass
import de.htwg.se.explodingKitten.model.stateComponent.State

abstract class StateImp(player : PlayerClass) extends State{
  def onLock()
  def onPlay()

}
