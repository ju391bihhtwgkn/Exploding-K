package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.GameStateComponent._
import org.scalatest.matchers.should._
import org.scalatest.wordspec.AnyWordSpec


class CarddeckSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")

  val kartenstapel = CardDeck.deck
  val card: Card = Card("ExplodingKitten")
  val card2 : Card = Card("MelonCat")

  "Add a Card(s)" when  {
    val temp = CardDeck.addCard("Skip", 1)
    "Len of Kartenstapel 1" in {
      temp.length should be (1)
    }
    "Add two of the same cards" in{
      val temp = CardDeck.addCard("Skip", 2)
      temp.length should be (2)
    }
  }
/*
  "Reduce Carddeck" in {
    println(CardDeck)
    val temp = CardDeck.reduceTop()
    temp.length should be (1)
  }

 */
}
