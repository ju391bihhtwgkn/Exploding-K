package de.htwg.se.explodingKitten.model

import com.google.inject.Guice
import de.htwg.se.explodingKitten.ExplodingKittenModule
import de.htwg.se.explodingKitten.controller.ContextComponent.ContextInterface
import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface
import de.htwg.se.explodingKitten.model.GameStateComponent._
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class StateSpec extends AnyWordSpec with Matchers{
  var player = Player("Wiebke", Vector[Card]())
  CardDeck.initializeDeck()
  val disPile = Vector(Card)

  val injector = Guice.createInjector(new ExplodingKittenModule)
  val controller = injector.getInstance(classOf[ControllerInterface])
  val context = injector.getInstance(classOf[ContextInterface])

  "test the handle with take Card" in {
//TODO keine Ahnung was man hier testen soll
  }


  /*"Check Status" when{
    "Status Play beginn" in{
      player.state shouldBe a [waitingStatus]
    }
    "Set Status" in {
      player.changeState(new playingStatus(player))
      player.state shouldBe a [playingStatus]
    }
  }

  "Check out what the methods do" when{
    "State should have Changed from Playing to Waiting" in {
      player.changeState(new playingStatus(player))
      player.state.onPlay()
      player.state shouldBe a [waitingStatus]
    }
    "State should have Changed form Playing to Waiting" in {
      player.changeState(new playingStatus(player))
      player.state.onLock()
      player.state shouldBe a [waitingStatus]
    }
    "State should have Changed from Waiting to  Playing" in {
      player.changeState(new playingStatus(player))
      player.state.onLock()
      player.state.onPlay()
      player.state shouldBe a [playingStatus]
    }
    "State should have Changed nothing" in {
      player.changeState(new playingStatus(player))
      player.state.onLock()
      player.state.onLock()
      player.state shouldBe a [waitingStatus]
    }
    "State should have Changed nothing in Death" in {
      player.changeState(new playingStatus(player))
      player.setHasLost()
      player.state.onPlay()
      player.state.onLock()
      player.state shouldBe a [diedStatus]
      player.state.onPlay()
      player.state shouldBe a [diedStatus]
    }
  }*/
}

