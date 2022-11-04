package view
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should._

class CarddeckSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")

  val kartenstapel: Carddeck = Carddeck()
  val card: Card = Card("Expl", "Death")

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
  val kartenstapel1 = kartenstapel.addCard(card)
  val kartenstapel2 = kartenstapel1.addCard(card)

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

  "Take a card" in {
    val k3 = kartenstapel2.addCard(card)
    k3.len() should be (3)
    k3.takeCard() should be (card)
    val k4 = k3.reduce()
    k4.len() should be (2)
  }

}
