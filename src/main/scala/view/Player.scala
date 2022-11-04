package view

case class Player(name: String,handCards: Vector[Card]) {

  var hasLost: Boolean = false;

  override def toString: String = name
}
