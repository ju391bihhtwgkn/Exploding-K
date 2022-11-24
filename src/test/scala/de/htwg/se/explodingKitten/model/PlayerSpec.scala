package de.htwg.se.explodingKitten.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")
  val card = Card("Melon Cat")
  "A Player" when {
    "set to Julian" should {
      val player = Player("Julian", Vector(Card("Melon Cat")))
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
      val player = Player("Julian", Vector(Card("Cat Card")))
      "have not lost" in {
        player.hasLost should be(false)
      }
    }
  }
}