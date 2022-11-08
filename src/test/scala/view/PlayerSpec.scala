import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import view.{Card, Player}

class PlayerSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")
  val card = Card("Melon Cat", "Combine 2 or 3 to draw a card from a Player")
  "A Player" when {
    "set to Julian" should {
      val player = Player("Julian", Vector(Card("Melon Cat", "Combine 2 or 3 to draw a card from a Player")))
      "have a name" in {
        player.name should be("Julian")
      }
      "have a nice String representation" in {
        player.toString should be("Julian")
      }
      "have 2 cards in his hands" in {
        player.handCards should be(List(card))
      }
    }
  }
  "A Player" when {
    "at the start of the game" should {
      val player = Player("Julian", Vector(Card("Cat Card", "Combine 2 or 3 to draw a card from a Player")))
      "have not lost" in {
        player.hasLost should be(false)
      }
    }
  }
}