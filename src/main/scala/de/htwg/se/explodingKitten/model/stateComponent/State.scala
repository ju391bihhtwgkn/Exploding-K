package de.htwg.se.explodingKitten.model.stateComponent

import de.htwg.se.explodingKitten.model.playerComponent.playerImpl.PlayerClass
import de.htwg.se.explodingKitten.model.stateComponent.stateImpl.StateImp

trait State {
  def onLock()
  def onPlay()
  case class waitingStatus(player : PlayerClass) extends StateImp(player)
}
