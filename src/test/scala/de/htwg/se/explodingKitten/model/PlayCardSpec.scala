package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.controller.ContextComponent.contextBaseimplementation.GameContext
import de.htwg.se.explodingKitten.controller.ControllerComponent.controllerBaseImplementation.Controller
import de.htwg.se.explodingKitten.model.GameStateComponent.Carddeck
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.PlayCard
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class PlayCardSpec() extends AnyWordSpec with Matchers{
  var p = Player("Ich", Vector(Card("SeeTheFuture"), Card("DrawFromTheBottom")))
  val c = new Controller(Carddeck().addCard(Card("FeralCat"), 2).addCard(Card("ExplodingKitten")).addCard(Card("SeeTheFuture"), 2))

  "Create a context" when {
    val tk = new PlayCard
    val context = new GameContext(tk)
    "Set the Strategy to TakeCard" in{
      context.strategy should be(tk)
    }
  }
  "Play a Card with spezific action" when {
    val context = new GameContext(new PlayCard)
    "Played the first Card" in{
      p = context.executeStrategy(p, c)
      p.handCards should be (Vector(Card("DrawFromTheBottom")))
      p = context.executeStrategy(p, c)
      p.handCards should be (Vector(Card("SeeTheFuture")))
    }

  }
}
