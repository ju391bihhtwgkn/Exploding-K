package de.htwg.se.explodingKitten.model.GamestateBaseImplementation

case class Player(name: String, handCards: Vector[Card], var hasLost: Boolean = false) {

  var state: State = new waitingStatus(this)

  def copyKonstruktor(): Player = {
    val p = Player(this.name, this.handCards, this.hasLost)
    p.changeState(this.state)
    p
  }

  def changeState(stat: State): Unit = state = stat

  def setHasLost(): Unit = hasLost = true

  def takeCard(card: Card): Player = {
    val p = Player(name, this.handCards :+ card)
    p.changeState(this.state)
    p
  }

  /*
  def playCard(stelle: Int): Player = {
    val idx = stelle - 1
    var temp = Vector[Card]()
    temp = handCards.take(idx)
    temp = temp ++ handCards.takeRight(handCards.length - idx - 1)
    val p = Player(name, temp, hasLost)
    p.changeState(this.state)
    p
  }

 */

  def playCard(card: Card): Vector[Card] = {
    val idx = handCards.indexOf(card)
    var temp = Vector[Card]()
    temp = handCards.take(idx)
    temp = temp ++ handCards.takeRight(handCards.length - idx - 1)
    temp
  }

  def chooseCardToPlay(cardNr: Int): Card = {
    val card = handCards.slice(cardNr - 1, cardNr)
    card.head
  }

  //override def toString: String = name + "\n" + handCards
  override def toString: String = name
}
