package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.controller.ContextComponent.contextBaseimplementation.GameContext
import de.htwg.se.explodingKitten.controller.ControllerComponent.controllerBaseImplementation.Controller
import de.htwg.se.explodingKitten.model.GameStateComponent._
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.TakeCard
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class TakeCardSpec() extends AnyWordSpec with Matchers{
  var p = Player("Ich", Vector(Card("SeeTheFuture")))
  val c = new Controller(new GameState())

  "Create a context" when {
    val tk = new TakeCard
    val context = new GameContext(tk)
    "Set the Strategy to TakeCard" in{
      context.strategy should be(tk)
    }
  }
  "Check out if its a Bomb" when {
    val bombcheck = new TakeCard
    "Bombe ohne Leben" in {
      bombcheck.checkOnExploding(1, GameState).hasLost should be (true)
    }
  }

  "Make a move" when {
    val context = new GameContext(new TakeCard)
    val deck = new Controller(Carddeck().addCard(Card("ExplodingKitten"),5))
    "Got a Bomb" in {
      context.executeStrategy(p, deck).handCards should be(p.handCards)
    }
    "Got no Bomb" in {
      context.executeStrategy(p, c).handCards should be (Vector(Card("SeeTheFuture"), Card("TacoCat")))
    }

  }


}
