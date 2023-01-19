package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.{Card, Gamestate, Player}
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.Carddeck.deck
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.Move


trait GameStateInterface {
  def currentPlayer:Int
  def players:Vector[Player]
  def deck: Vector[Card]
  def discardPile: Vector[Card]
  def handle(move: Move) : Gamestate
}
