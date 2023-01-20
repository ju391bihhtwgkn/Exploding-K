package de.htwg.se.explodingKitten

import com.google.inject.AbstractModule
import de.htwg.se.explodingKitten.controller.ControllerInterface
import de.htwg.se.explodingKitten.controller.controllerBaseImplementation.Controller

class ExplodingKittenModule extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[ControllerInterface]).toInstance(Controller())
  }
}
