package de.htwg.se.explodingKitten.model

import com.google.inject.Guice
import de.htwg.se.explodingKitten.ExplodingKitten.injector
import de.htwg.se.explodingKitten.ExplodingKittenModule
import de.htwg.se.explodingKitten.controller.ContextComponent.ContextInterface
import de.htwg.se.explodingKitten.controller.ContextComponent.contextBaseimplementation.GameContext
import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface
import de.htwg.se.explodingKitten.controller.ControllerComponent.controllerBaseImplementation.Controller
import de.htwg.se.explodingKitten.model.GameStateComponent._
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation._
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.{Move, TakeCard}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class TakeCardSpec() extends AnyWordSpec with Matchers{
  CardDeck.initializeDeck()
  val injector = Guice.createInjector(new ExplodingKittenModule)
  val controller = injector.getInstance(classOf[ControllerInterface])
  val context = injector.getInstance(classOf[ContextInterface])
  var p1 = Player("Ich", Vector(Card("SeeTheFuture")))
  var p2= Player("Du", Vector(Card("SeeTheFuture")))
  CardDeck.initializeDeck()
  val gamestate = Gamestate(1, Vector(p1, p2),CardDeck.deck , Vector())


  //controller.gameState

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
      val gamestate2 = bombcheck.checkOnExploding(0, gamestate )
      var gamestate3 = Gamestate(1, Vector(p2), CardDeck.deck, Vector())
      gamestate2 should be (gamestate3)
    }
  }

//TODO Der Teil funktioniert noch nicht

  "Make a move" when {
    val move = new TakeCard
    //val gamestate = Gamestate(0, Vector(p1, p2),CardDeck.deck , Vector())
    "Got no Bomb" in {
      context.executeStrategy(controller).handle(move) should not be (move)
    }

  }


}
