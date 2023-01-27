package de.htwg.se.explodingKitten.model.FileIOComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateInterface

trait FileIOInterface {
  def save(gameState: GameStateInterface): Unit
  def load: GameStateInterface
}
