package de.htwg.se.explodingKitten.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec() extends AnyWordSpec with Matchers {
  //val card = Card("MelonCat")
  "A Player" when {
    "set to Julian" should {
      val player = Player("Julian", Vector(Card("MelonCat")))
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
  "A Player" when {
    "at the start of the game" should {
      val player = Player("Julian", Vector(Card("MelonCat")))
      "have not lost" in {
        player.hasLost should be(false)
      }
    }
  }
}