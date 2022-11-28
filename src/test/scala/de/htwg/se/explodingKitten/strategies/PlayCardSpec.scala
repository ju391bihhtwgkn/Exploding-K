package de.htwg.se.explodingKitten.strategies

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.explodingKitten.model.Cards._
import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.{Card, Carddeck, Player}
import strategies.{GameContext, PlayCard}


class PlayCardSpec() extends AnyWordSpec with Matchers{
  var p = Player("Ich", Vector(lookToFuture, cardFromBottom))
  val c = new Controller(Carddeck().addCard(cat, 2).addCard(explCard).addCard(lookToFuture, 2))

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
      p.handCards should be (Vector(cardFromBottom))
      p = context.executeStrategy(p, c)
      p.handCards should be (Vector(lookToFuture))
    }

  }
}
