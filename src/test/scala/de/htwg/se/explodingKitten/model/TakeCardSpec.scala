package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.controller.controllerBaseImplementation.{Controller, GameContext}
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Carddeck, Player}
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.TakeCard
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class TakeCardSpec() extends AnyWordSpec with Matchers{
  var p = Player("Ich", Vector(Card("SeeTheFuture")))
  val c = new Controller(Carddeck().addCard(Card("TacoCat"), 2).addCard(Card("ExplodingKitten")).addCard(Card("DrawFromTheBottom"), 2))

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
      bombcheck.checkOnExploding(p, c, Card("ExplodingKitten")).hasLost should be (true)
    }
    "Bombe mit Leben" in {
      p = p.takeCard(Card("Defuse"))
      bombcheck.checkOnExploding(p, c, Card("ExplodingKitten")).hasLost should be (false)
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
