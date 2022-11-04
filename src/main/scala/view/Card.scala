package view

case class Card(val name: String,val description: String) {
  val cardWith = 20

  val eol = sys.props("line.separator")

  def cardName(name: String): String = ("+++" + name + "+++") + eol

  def cardDescription(description: String): String = ("+++" + description + "+++") + eol

  def card(name: String, description: String) = cardName(name) + cardDescription(description)

  override def toString: String = card(name, description)
}
