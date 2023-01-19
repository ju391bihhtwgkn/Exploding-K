package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Player, playingStatus}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")
  val card = Card("MelonCat")
  "A Player" when {
    "set to Julian" should {
      val player = Player("Julian", Vector(Card("Melon Cat")))
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
      "loose the Game" in {
        player.setHasLost()
        player.hasLost should be(true)
      }
    }
  }

  "Player should Play with Cards" should {
    val player2 = Player("Wiebke", Vector(Card("MelonCat"), Card("ExplodingKitten"), Card("SeeTheFuture"), Card("Defuse"), Card("MelonCat")))
    "Take a Card" in{
      player2.takeCard(Card("MelonCat")).handCards should be (Vector(Card("MelonCat"), Card("ExplodingKitten"), Card("SeeTheFuture"), Card("Defuse"), Card("MelonCat"), Card("MelonCat")))
    }
    "Play Card with Index" in {
      player2.playCard(2).handCards should be (Vector(Card("MelonCat"), Card("SeeTheFuture"), Card("Defuse"), Card("MelonCat")))
    }
    "Play Card with Card" in {
      player2.playCard(Card("SeeTheFuture")).handCards should be (Vector(Card("MelonCat"), Card("ExplodingKitten"), Card("Defuse"), Card("MelonCat")))
    }
    "Play Card with Card (2 same on hand)" in {
      player2.playCard(Card("MelonCat")).handCards should be (Vector(Card("ExplodingKitten"), Card("SeeTheFuture"), Card("Defuse"), Card("MelonCat")))
    }
  }

  "Choose a Card to Play" in {
    val player = Player("Julian", Vector(Card("MelonCat"), Card("Defuse"), Card("SeeTheFuture")))
    player.chooseCardToPlay(2) should be (Card("Defuse"))
    player.chooseCardToPlay(1) should be (Card("MelonCat"))
    player.chooseCardToPlay(3) should be (Card("SeeTheFuture"))
  }

  "check Status" when {
    val p1 = Player("P1", Vector(Card("MelonCat")))
    p1.changeState(new playingStatus(p1))
    "Status play" in {
      p1.state shouldBe a [playingStatus]
    }
    val p2 = p1.takeCard(Card("MelonCat"))
    "Status is still playing" in {
      p2.state shouldBe a [playingStatus]
    }
  }
}