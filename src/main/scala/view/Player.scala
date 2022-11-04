package view

case class Player(name: String) {

  var hasLost: Boolean = false;

  override def toString: String = name
}
