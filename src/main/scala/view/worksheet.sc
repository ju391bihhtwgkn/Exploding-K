import view.playboard

import scala.io.StdIn.readLine
import scala.util.Random

case class Card(val name: String,val description: String) {
  val cardWith = 20

  val eol = sys.props("line.separator")

  def cardName(name: String): String = ("+++" + name + "+++") + eol

  def cardDescription(description: String): String = ("+++" + description + "+++") + eol

  def card(name: String, description: String) = cardName(name) + cardDescription(description)

  override def toString: String = card(name, description)
}

val drawFromTheBottom = new Card("Draw from the bottom", "End your turn by drawing the card at the bottom of the draw pile")

val catCard = new Card("Melon Cat", "Combine 2 or 3 to draw a card from a Player")
print(catCard)

val explodingKittenCard = new Card("Exploding Kitten", "You explode")
val defuseCard = new Card("Defuse", "Put your last drawn Card back into the deck")
print(explodingKittenCard)

val list = List(defuseCard, explodingKittenCard, drawFromTheBottom, catCard)

object Deck {
  //def shuffle = new Deck(Random.shuffle(cards))
  val cards = list
  val numberOfCards = cards.length.toInt
  val eol = sys.props("line.separator")
  for(i <- 1 to numberOfCards) println(i + " ----------")
  //def field(size: Int): String = new StringBuilder()(size * ("--------" + eol))
}



//val playingDeck = Deck.field(10)
//playingDeck.foreach(println)

print(Deck)



case class Player(name: String, handCards: List[Card]) {

  var hasLost = false;

  override def toString: String = name

}

//val list: List[Card] = List(Card("da","ba"), Card("ba","da"))

/*
val player1 = new Player("Julian",List(Card("da","ba"), Card("ba","da")))
print(player1)

print("test")
print(player1.handCards.tail)

print(player1.handCards.head)


val reallist = player1.handCards

*/
