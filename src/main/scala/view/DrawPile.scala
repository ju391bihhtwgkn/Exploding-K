package view

object DrawPile {

  val catCard = new Card("Melon Cat", "Combine 2 or 3 to draw a card from a Player")
  val explodingKittenCard = new Card("Exploding Kitten", "You explode")
  val defuseCard = new Card("Defuse", "Put your last drawn Card back into the deck")
  val drawFromTheBottom = new Card("Draw from the bottom", "End your turn by drawing the card at the bottom of the draw pile")

  def createDeck(): List[Card] = List(explodingKittenCard, drawFromTheBottom, drawFromTheBottom, catCard, explodingKittenCard, catCard)

}
