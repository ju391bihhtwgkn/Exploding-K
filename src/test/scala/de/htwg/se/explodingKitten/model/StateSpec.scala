package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.GameStateComponent._
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class StateSpec extends AnyWordSpec with Matchers{
  var player = Player("Wiebke", Vector(Card("TacoCat"), Card("TacoCat"), Card("TacoCat")))
  CardDeck.initializeDeck()
  val disPile = Vector[Card]

  "Make a Gamestate" in {
    GameStateInterface()
  }
}

