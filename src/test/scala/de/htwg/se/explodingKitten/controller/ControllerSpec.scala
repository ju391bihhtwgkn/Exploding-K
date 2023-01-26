package de.htwg.se.explodingKitten.controller

import de.htwg.se.explodingKitten.ExplodingKitten.injector
import de.htwg.se.explodingKitten.controller.ControllerComponent._
import de.htwg.se.explodingKitten.model.GameStateComponent._
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.util.Observer
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers {

  val card = Card("MelonCat")
  val card2 = Card("ExplodingKitten")
  val cardBottom = Card("DrawFromTheBottom")
  print(card)

  "A Controller" when {
    "instilizes deck" in {
      var controller = injector.getInstance(classOf[ControllerInterface])
      controller.initializeDeck()
      controller.gameState.deck should not be empty

    }
  }
  "A Controller" when {
    var controller = injector.getInstance(classOf[ControllerInterface])

    "creats player" in {
        controller.createPlayers(List("Ich", "Du"))
        controller.gameState.players.length should be (2)
      }
      "initialisiert Player" in{
        val p1 = Player("Er", Vector())
        val p2 = Player("Sie", Vector())
        controller.initializePlayers(Vector(p1, p2))
        controller.flag should be (true)
      }

    }
}
//
//val observer = new Observer {
//var updated: Boolean = false
//def isUpdated: Boolean = updated
//override def update: Unit = {updated = true; updated}
//}
//controller.add(observer)