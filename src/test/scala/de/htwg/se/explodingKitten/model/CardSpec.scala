package de.htwg.se.explodingKitten.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CardSpec() extends AnyWordSpec with Matchers {
  val eol: String = sys.props("line.separator")
  val DrawFromTheBottom: Card = Card("DrawFromTheBottom")
  val SeeTheFuture: Card = Card("SeeTheFuture")
  val Skip: Card = Card("Skip")
  val Attack: Card = Card("Attack")
  val TargetedAttack: Card = Card("TargetedAttack")
  val Defuse: Card = Card("Defuse")
  val ExplodingKitten: Card = Card("ExplodingKitten")
  val AlterTheFuture: Card = Card("AlterTheFuture")
  val FeralCat: Card = Card("FeralCat")
  val MelonCat: Card = Card("MelonCat")
  val BeardedCat: Card = Card("BeardedCat")
  val TacoCat: Card = Card("TacoCat")
  val HairyPotatoCat: Card = Card("HairyPotatoCat")
  val RainbowCat: Card = Card("RainbowCat")

  "have a name " in {
    DrawFromTheBottom.cardName should be("Draw from the Bottom")
    SeeTheFuture.cardName should be("See the Future")
    Skip.cardName should be("Skip")
    Attack.cardName should be("Attack")
    TargetedAttack.cardName should be("Targeted Attack")
    Defuse.cardName should be("Defuse")
    ExplodingKitten.cardName should be("Exploding Kitten")
    AlterTheFuture.cardName should be("Alter the Future")
    FeralCat.cardName should be("Feral Cat")
    MelonCat.cardName should be("Melon Cat")
    BeardedCat.cardName should be("Bearded Cat")
    TacoCat.cardName should be("Taco Cat")
    HairyPotatoCat.cardName should be("Hairy Potato Cat")
    RainbowCat.cardName should be("Rainbow Cat")
  }
  "have a description" in {
    DrawFromTheBottom.cardDescription should be("Draw a card from the Bottom")
    SeeTheFuture.cardDescription should be("Look at the top 3 cards")
    Skip.cardDescription should be("End your turn without drawing a card")
    Attack.cardDescription should be("End your turn without drawing a card.\n" + "Force the next player to take 2 turns")
    TargetedAttack.cardDescription should be("End your turn and force the player of your choice to take two turns.")
    Defuse.cardDescription should be("Defuse the exploding kitten")
    ExplodingKitten.cardDescription should be("BOOOOM!")
    AlterTheFuture.cardDescription should be("Privately view and rearrange the top three cards in the draw pile")
    FeralCat.cardDescription should be("Use this as any cat card")
    MelonCat.cardDescription should be("Combine 2 or 3 to draw a card from a player")
    BeardedCat.cardDescription should be("Combine 2 or 3 to draw a card from a player")
    TacoCat.cardDescription should be("Combine 2 or 3 to draw a card from a player")
    HairyPotatoCat.cardDescription should be("Combine 2 or 3 to draw a card from a player")
    RainbowCat.cardDescription should be("Combine 2 or 3 to draw a card from a player")
  }
  "have a name and description" in {
    DrawFromTheBottom.card should be ("Draw from the Bottom" + eol + "Draw a card from the Bottom")
    SeeTheFuture.card should be("See the Future" + eol + "Look at the top 3 cards")
    Skip.card should be("Skip" + eol + "End your turn without drawing a card")
    Attack.card should be("Attack" + eol + "End your turn without drawing a card.\n" + "Force the next player to take 2 turns")
    TargetedAttack.card should be("Targeted Attack" + eol + "End your turn and force the player of your choice to take two turns.")
    Defuse.card should be("Defuse" + eol + "Defuse the exploding kitten")
    ExplodingKitten.card should be("Exploding Kitten" + eol + "BOOOOM!")
    AlterTheFuture.card should be("Alter the Future" + eol + "Privately view and rearrange the top three cards in the draw pile")
    FeralCat.card should be("Feral Cat" + eol + "Use this as any cat card")
    MelonCat.card should be("Melon Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    BeardedCat.card should be("Bearded Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    TacoCat.card should be("Taco Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    HairyPotatoCat.card should be("Hairy Potato Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    RainbowCat.card should be("Rainbow Cat" + eol + "Combine 2 or 3 to draw a card from a player")
  }
  "should have a nice string representation" in {
    DrawFromTheBottom.toString() should be ("Draw from the Bottom" + eol + "Draw a card from the Bottom")
    SeeTheFuture.toString() should be("See the Future" + eol + "Look at the top 3 cards")
    Skip.toString() should be("Skip" + eol + "End your turn without drawing a card")
    Attack.toString() should be("Attack" + eol + "End your turn without drawing a card.\n" + "Force the next player to take 2 turns")
    TargetedAttack.toString() should be("Targeted Attack" + eol + "End your turn and force the player of your choice to take two turns.")
    Defuse.toString() should be("Defuse" + eol + "Defuse the exploding kitten")
    ExplodingKitten.toString() should be("Exploding Kitten" + eol + "BOOOOM!")
    AlterTheFuture.toString() should be("Alter the Future" + eol + "Privately view and rearrange the top three cards in the draw pile")
    FeralCat.toString() should be("Feral Cat" + eol + "Use this as any cat card")
    MelonCat.toString() should be("Melon Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    BeardedCat.toString() should be("Bearded Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    TacoCat.toString() should be("Taco Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    HairyPotatoCat.toString() should be("Hairy Potato Cat" + eol + "Combine 2 or 3 to draw a card from a player")
    RainbowCat.toString() should be("Rainbow Cat" + eol + "Combine 2 or 3 to draw a card from a player")
  }
}
/*
"A Card" when {
  "name is set to Melon Cat and description is set" should {
    val card = Card("Melon Cat")
    card.cardName in {
      cardName should be("Melon Cat")
    }
    "have a description" in {
      card.description should be("Combine 2 or 3 to draw a card from a Player")
    }
  }
};}



 */