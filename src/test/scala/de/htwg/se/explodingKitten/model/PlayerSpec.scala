package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.Cards._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import status.{playingStatus, waitingStatus}

class PlayerSpec() extends AnyWordSpec with Matchers {
  val eol = sys.props("line.separator")
  val card = Card("Melon Cat", "Combine 2 or 3 to draw a card from a Player", 1)
  "A Player" when {
    "set to Julian" should {
      val player = Player("Julian", Vector(Card("Melon Cat", "Combine 2 or 3 to draw a card from a Player", 1)))
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
      val player = Player("Julian", Vector(Card("Cat Card", "Combine 2 or 3 to draw a card from a Player", 1)))
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
    val player2 = Player("Wiebke", Vector(cat, explCard, lookToFuture, defuseCard, cat))
    "Take a Card" in{
      player2.takeCard(cat).handCards should be (Vector(cat, explCard, lookToFuture, defuseCard, cat, cat))
    }
    "Play Card with Index" in {
      player2.playCard(2).handCards should be (Vector(cat, lookToFuture, defuseCard, cat))
    }
    "Play Card with Card" in {
      player2.playCard(lookToFuture).handCards should be (Vector(cat, explCard, defuseCard, cat))
    }
    "Play Card with Card (2 same on hand)" in {
      player2.playCard(cat).handCards should be (Vector(explCard, lookToFuture, defuseCard, cat))
    }
  }

  "Choose a Card to Play" in {
    val player = Player("Julian", Vector(cat, defuseCard, lookToFuture))
    player.chooseCardToPlay(2) should be (defuseCard)
    player.chooseCardToPlay(1) should be (cat)
    player.chooseCardToPlay(3) should be (lookToFuture)
  }

  "check Status" when {
    val p1 = Player("P1", Vector(cat))
    p1.changeState(new playingStatus(p1))
    "Status play" in {
      p1.state shouldBe a [playingStatus]
    }
    val p2 = p1.takeCard(cat)
    "Status is still playing" in {
      p2.state shouldBe a [playingStatus]
    }
  }
}