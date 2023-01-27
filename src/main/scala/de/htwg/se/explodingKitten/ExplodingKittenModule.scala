package de.htwg.se.explodingKitten

import com.google.inject.AbstractModule
import de.htwg.se.explodingKitten.controller.ContextComponent._
import de.htwg.se.explodingKitten.controller.ContextComponent.contextBaseimplementation.GameContext
import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface
import de.htwg.se.explodingKitten.controller.ControllerComponent.controllerBaseImplementation.Controller
import de.htwg.se.explodingKitten.model.FileIOComponent.FileIOInterface
import de.htwg.se.explodingKitten.model.FileIOComponent.FileIOJsonImplenentation.FileIOJsonImplementation
import de.htwg.se.explodingKitten.model.FileIOComponent.FileIOXmlImplementation.FileIOXmlImplementation
import de.htwg.se.explodingKitten.model.GameStateComponent.Card
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import de.htwg.se.explodingKitten.model.StrategyComponent.TakeCard

class ExplodingKittenModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[ControllerInterface]).toInstance(Controller(Gamestate(0, Vector[Player](), Vector[Card](), Vector(Card("FeralCat")))))
    bind(classOf[ContextInterface]).toInstance(GameContext(new TakeCard))
    //bind(classOf[FileIOInterface]).toInstance(new FileIOJsonImplementation())
    bind(classOf[FileIOInterface]).toInstance(new FileIOXmlImplementation())
  }
}
