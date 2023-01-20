package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Card, Gamestate}
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.Move
import de.htwg.se.explodingKitten.model.PlayerComponent.Player


trait GameStateInterface {
  def currentPlayer:Int
  def players:Vector[Player]
  def deck: Vector[Card]
  def discardPile: Vector[Card]
  def handle(move: Move) : GameStateInterface
}
