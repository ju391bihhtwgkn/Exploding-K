package view

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec() extends AnyWordSpec with Matchers {
  "A Player" when {
    "set to Julian" should {
      val player = Player("Julian")
      "have a name" in {
        player.name should be("Julian")
      }
      "have a nice String representation" in {
        player.toString should be("Julian")
      }
    }
  }
  "A Player" when {
    "at the start of the game" should {
      val player = Player("Julian")
      "have not lost" in {
        player.hasLost should be(false)
      }
    }
  }
}
