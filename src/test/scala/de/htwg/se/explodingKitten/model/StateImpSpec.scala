package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.playerComponent.playerImpl.PlayerClass
import de.htwg.se.explodingKitten.model.stateComponent.diedStatus
import de.htwg.se.explodingKitten.model.stateComponent.stateImpl.{diedStatus, playingStatus, waitingStatus}
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class StateImpSpec extends AnyWordSpec with Matchers{
  var player = PlayerClass("Wiebke", Vector(Card("TacoCat"), Card("TacoCat"), Card("TacoCat")))
  "Check Status" when{
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
  }
}
