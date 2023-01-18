package de.htwg.se.explodingKitten.model.cardComponent

import de.htwg.se.explodingKitten.model.cardComponent.cardImpl.Cards.{AlterTheFuture, Attack, BeardedCat, Defuse, DrawFromTheBottom, ExplodingKitten, FeralCat, HairyPotatoCat, MelonCat, RainbowCat, SeeTheFuture, Skip, TacoCat, TargetedAttack}

trait Card {
  //def apply(unit: Unit): Any = ???

  def cardName: String

  def cardDescription: String

  def card: String

  def actionCode: Int

  def toString: String

  def Cards(s: String) : Card = apply(s): Card
}
