package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.GameStateComponent._
import org.scalatest.matchers.should._
import org.scalatest.wordspec.AnyWordSpec


class CarddeckSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")

  val kartenstapel = CardDeck.initializeDeck()
  val card: Card = Card("ExplodingKitten")
  val card2 : Card = Card("MelonCat")

  "Add a Card(s)" when  {
    val temp = CardDeck.addCard("Skip", 1)
    "Len of Kartenstapel 1" in {
      temp.length should be (28)
    }
    "Add two of the same cards" in{
      val temp = CardDeck.addCard("Skip", 2)
      temp.length should be (29)
    }
  }

  "Reduce Carddeck" in{
    CardDeck.reduceTop().length should be (26)
  }
}
