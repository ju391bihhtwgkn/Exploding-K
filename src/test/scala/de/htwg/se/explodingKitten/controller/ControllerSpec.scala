package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.model.{Card, Carddeck}
import de.htwg.se.explodingKitten.util.Observer
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers {

  val card = Card("MelonCat")
  val card2 = Card("ExplodingKitten")
  val cardBottom = Card("DrawFromTheBottom")
  print(card)

  "A Controller" when {
    "instilizes deck" should {
      var controller = new Controller()
      controller.initializeDeck()
    }
  }
  "A Controller" when {
    "observed by an Observer" should {
      val controller = new Controller(Carddeck())
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
        override def update: Unit = {updated = true; updated}
      }
      controller.add(observer)
      "notify its Observers after card is added to the deck" in {
        controller.addCard(card, 4)
        controller.addCard(card2, 8)
        controller.addCard(Card("DrawFromTheBottom"),5)
        observer.updated should be(true)
        controller.deck.len() should be(17)
      }
      "notify its Observers after card is drawn from the top" in {
        val x = controller.takeTopCard()
        observer.updated should be(true)
        controller.deck.len() should be(16)
        x.cardName should be("Melon Cat")
        x.cardDescription should be("Combine 2 or 3 to draw a card from a player")
        x should be (card)
        //x should be (Card("MelonCat"))
      }
      "notify its Observers after card is drawn from the bottom" in {
        val y = controller.takeCardBottom()
        observer.updated should be(true)
        controller.deck.len() should be(15)
        y should be(Card("DrawFromTheBottom"))
        y.cardName should be ("Draw from the bottom")
        y.cardDescription should be ("Draw a card from the bottom")
      }
      "notify its Observers after a player looked at the top 3 Cards" in {
        val spy = controller.spy()
        observer.updated should be(true)
        spy should be(Vector(card, card, card))
      }
      "notify its Observers after the deck was shuffled" in {
        val unshuffled = controller.deck
        val shuffled = controller.shuffle()
        observer.updated should be(true)
        shuffled.deck should not be(unshuffled.deck)
      }
      "notify its Observers after the player put a card into the deck" in {
        val explodingCard = Card("ExplodingKitten")
        controller.hideCardInDeck(explodingCard, 0)
        observer.updated should be(true)
        controller.deck.takeCardTop() should be(explodingCard)
      }
    }
  }
}