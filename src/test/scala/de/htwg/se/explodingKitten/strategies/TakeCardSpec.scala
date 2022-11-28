package de.htwg.se.explodingKitten.strategies
import de.htwg.se.explodingKitten.model.Cards._
import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.{Card, Carddeck, Player}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import strategies.{GameContext, TakeCard}


class TakeCardSpec() extends AnyWordSpec with Matchers{
  var p = Player("Ich", Vector(lookToFuture))
  val c = new Controller(Carddeck().addCard(cat, 2).addCard(explCard).addCard(cardFromBottom, 2))

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
      bombcheck.checkOnExploding(p, c, explCard).hasLost should be (true)
    }
    "Bombe mit Leben" in {
      p = p.takeCard(defuseCard)
      bombcheck.checkOnExploding(p, c, explCard).hasLost should be (false)
    }

  }

  "Make a move" when {
    val context = new GameContext(new TakeCard)
    val deck = new Controller(Carddeck().addCard(explCard,5))
    "Got a Bomb" in {
      context.executeStrategy(p, deck).handCards should be(p.handCards)
    }
    "Got no Bomb" in {
      context.executeStrategy(p, c).handCards should be (Vector(lookToFuture, cat))
    }

  }

}
