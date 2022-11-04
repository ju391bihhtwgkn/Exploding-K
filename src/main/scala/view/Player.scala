package model

import view.Card

case class Player(name: String, handCards: List[Card]) {

  var hasLost: Boolean = false;

  override def toString: String = name
}
