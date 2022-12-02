package de.htwg.se.explodingKitten.model

class waitingStatus(player : Player) extends State(player) {

  override def onLock(): Unit = return

  override def onPlay(): Unit = player.changeState(new playingStatus(player))
}

class playingStatus(player: Player) extends State(player){

  override def onLock(): Unit = player.changeState(new waitingStatus(player))

  override def onPlay(): Unit = {
    if(player.hasLost) {
      player.changeState(new diedStatus(player))
      return
    }
    player.changeState(new waitingStatus(player))
  }

}

class diedStatus(player : Player) extends State(player){
//cant do anything course it is death

  override def onLock(): Unit = player.changeState(new diedStatus(player))

  override def onPlay(): Unit = player.changeState(new diedStatus(player))

}
