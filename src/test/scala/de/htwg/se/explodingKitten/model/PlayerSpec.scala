package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.GameStateComponent._
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")
  val card = Card("MelonCat")
  "A Player" when {
    "set to Julian" should {
      val player = Player("Julian", Vector(Card("Skip")))
      "have a name" in {
        player.name should be("Julian")
      }
      "have a nice String representation" in {
        player.toString should be("Julian")
      }
      "have 1 cards in his hands" in {
        player.handCards.length should be(1)
      }
    }
  }

  "Player should Play with Cards" should {
    val player2 = Player("Wiebke", Vector(Card("Skip"), Card("Shuffle"), Card("Skip")))
    "Play Card with Card" in {
      val temp = player2.playCard(Card("Shuffle"))
      temp.length should be (2)
    }
    "Play Card with Card (2 same on hand)" in {
      val temp = player2.playCard(Card("Skip"))
      temp.length should be (2)
    }
    "Player choose a Card" in {
      val temp = player2.chooseCardToPlay(1)
      temp.cardName should be ("Skip")
    }
  }
}