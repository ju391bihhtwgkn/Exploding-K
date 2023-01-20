package de.htwg.se.explodingKitten

import com.google.inject.AbstractModule
import de.htwg.se.explodingKitten.controller.ControllerInterface
import de.htwg.se.explodingKitten.controller.controllerBaseImplementation.Controller
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Card, Gamestate}
import de.htwg.se.explodingKitten.model.PlayerComponent.Player

class ExplodingKittenModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[ControllerInterface]).toInstance(Controller())
  //Gamestate(0, Vector[Player](), Vector[Card](), Vector(Card("FeralCat"))))
  }
}
