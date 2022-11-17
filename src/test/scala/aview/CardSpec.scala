package aview


import de.htwg.se.explodingKitten.model.Card
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CardSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")
  val card = new Card("","")
  "have a name " in {
    card.cardName("Melon Cat") should be ("+++ Melon Cat +++" + eol)
  }
  "have a description" in {
    card.cardDescription("Combine 2 or 3 to draw a card from a Player") should be("+++ Combine 2 or 3 to draw a card from a Player +++" + eol)
  }
  "have a name and description" in {
    card.card("Melon Cat", "Combine 2 or 3 to draw a card from a Player") should be("+++ Melon Cat +++" + eol +  "+++ Combine 2 or 3 to draw a card from a Player +++" + eol)
  }
  "should have a nice string representation" in {
    val card = Card("Melon Cat", "Combine 2 or 3 to draw a card from a Player")
    card.toString() should be("+++ Melon Cat +++" + eol + "+++ Combine 2 or 3 to draw a card from a Player +++" + eol)
  }

  "A Card" when {
    "name is set to Melon Cat and description is set" should {
      val card = new Card("Melon Cat","Combine 2 or 3 to draw a card from a Player")
      card.cardName("Melon Cat") in {
        card.name should be("Melon Cat")
      }
      "have a description" in {
        card.description should be("Combine 2 or 3 to draw a card from a Player")
      }
    }
  };}

