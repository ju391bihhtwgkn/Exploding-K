package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.cardComponent._
import org.scalatest.matchers.should._
import org.scalatest.wordspec.AnyWordSpec


class CarddeckSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")

  val kartenstapel: Carddeck = Carddeck()
  val card: Card = Cards("ExplodingKitten")
  val card2 : Card = Cards("MelonCat")

  "Create empty Carddeck" in {
    kartenstapel.len() should be (0)
  }

  "Add a Card(s)" should  {
    val kartenstapel2 = kartenstapel.addCard(card)
    "Len of Kartenstapel 1" in {
      kartenstapel2.len() should be (1)
    }
    "Add two of the same cards" in{
      kartenstapel2.addCard(card, 2).deck should be (Vector(card, card, card))
    }
  }
  val kartenstapel2 = kartenstapel.addCard(card, 2)

  "Look first 3 Cards" should {

    "with just two in deck" in{
      kartenstapel2.len() should be(2)
      kartenstapel2.spy() should be(Vector(card, card))
    }
    val kartenstapel3 = kartenstapel2.addCard(card)
    "with just three in deck" in{
      kartenstapel3.len() should be (3)
      kartenstapel3.spy() should be(Vector(card, card, card))
    }
  }

  val k3 = kartenstapel2.addCard(card2)

  "Take a card " should  {
    "from the Top" in {
      k3.len() should be (3)
      k3.takeCardTop() should be (card)
      val k4 = k3.reduceTop()
      k4.len() should be (2)
    }
    "from the Bottom" in {
      k3.len() should be (3)
      k3.takeCardBottom() should be (card2)
      val k4 = k3.reduceBottom()
      k4.len() should be (2)
    }
  }

  "Shuffle Cards" should  {
    val k3 = kartenstapel2.addCard(card2, 2)
    val k5 = k3.shuffleDeck()
    "Not the same as before" in {
      k5.deck should not be (k3.deck)
    }
    "Still have the all Elements" in {
      k5.len() should be (k3.len())
    }
  }

  "Put Exploding Kitten in the Deck" should  {
    val c1 = Cards("MelonCat")
    val c2 = Cards("ExplodingKitten")
    val cDeck = Carddeck().addCard(c1, 4)
    "On Top" in {
      cDeck.hideCardInDeck(c2, 0).deck should be (Vector(c2, c1, c1, c1, c1))
    }
    "In the middle" in {
      cDeck.hideCardInDeck(c2, 3).deck should be (Vector(c1, c1, c2, c1, c1))
    }
    "At the End" in {
      cDeck.hideCardInDeck(c2, 5).deck should be (Vector(c1, c1, c1, c1, c2))
    }

  }

}