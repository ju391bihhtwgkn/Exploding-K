package de.htwg.se.explodingKitten.model.GameStateComponent

trait Card {
  def cardName: String
  def cardDescription: String
  def card: String
  def actionCode: Int
  def toString: String
}

object Card {

  val eol = sys.props("line.separator")
  private class DrawFromTheBottom extends Card {
    override def cardName: String = "Draw From The Bottom"
    override def cardDescription: String = "Draw a card from the Bottom"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 1
    override def toString: String = card
  }

  private class SeeTheFuture extends Card {
    override def cardName: String = "See The Future"
    override def cardDescription: String = "Look at the top 3 cards"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 2
    override def toString: String = card
  }

  private class Skip extends Card {
    override def cardName: String = "Skip"
    override def cardDescription: String = "End your turn without drawing a card"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 3
    override def toString: String = card
  }

  private class Attack extends Card {
    override def cardName: String = "Attack"
    override def cardDescription: String = "End your turn without drawing a card.\n" +
      "Force the next player to take 2 turns"
    override def card: String = cardName + eol + cardDescription
    override def actionCode: Int = 4
    override def toString: String = card

  }

  private class TargetedAttack extends Card {
    override def cardName: String = "Targeted Attack"
    override def cardDescription: String = "End your turn and force the player of your choice to take two turns."
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 5
    override def toString: String = card
  }

  private class Defuse extends Card {
    override def cardName: String = "Defuse"
    override def cardDescription: String = "Defuse the exploding kitten"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 6
    override def toString: String = card
  }

  private class ExplodingKitten extends Card {
    override def cardName: String = "Exploding Kitten"
    override def cardDescription: String = "BOOOOM!"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 7
    override def toString: String = card
  }

  private class AlterTheFuture extends Card {
    override def cardName: String = "Alter The Future"
    override def cardDescription: String = "Privately view and rearrange the top three cards in the draw pile"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 8
    override def toString: String = card
  }
  private class FeralCat extends Card {
    override def cardName: String = "Feral Cat"
    override def cardDescription: String = "Use this as any cat card"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 9
    override def toString: String = card
  }

  private class MelonCat extends Card {
    override def cardName: String = "Melon Cat"
    override def cardDescription: String = "Combine 2 or 3 to draw a card from a player"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 10
    override def toString: String = card
  }

  private class BeardedCat extends Card {
    override def cardName: String = "Bearded Cat"
    override def cardDescription: String = "Combine 2 or 3 to draw a card from a player"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 11
    override def toString: String = card
  }

  private class TacoCat extends Card {
    override def cardName: String = "Taco Cat"
    override def cardDescription: String = "Combine 2 or 3 to draw a card from a player"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 12
    override def toString: String = card
  }

  private class HairyPotatoCat extends Card {
    override def cardName: String = "Hairy Potato Cat"
    override def cardDescription: String = "Combine 2 or 3 to draw a card from a player"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 13
    override def toString: String = card
  }

  private class RainbowCat extends Card {
    override def cardName: String = "Rainbow Cat"
    override def cardDescription: String = "Combine 2 or 3 to draw a card from a player"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 14
    override def toString: String = card
  }

  private class Shuffle extends Card {
    override def cardName: String = "Shuffle"
    override def cardDescription: String = "Shuffle the deck"
    override def card:String = cardName + eol + cardDescription
    override def actionCode: Int = 15
    override def toString: String = card
  }



  def apply(s: String): Card = {
    s match {
      case "DrawFromTheBottom" => new DrawFromTheBottom
      case "SeeTheFuture" => new SeeTheFuture
      case "Skip" => new Skip
      case "Attack" => new Attack
      case "TargetedAttack" => new TargetedAttack
      case "Defuse" => new Defuse
      case "ExplodingKitten" => new ExplodingKitten
      case "AlterTheFuture" => new AlterTheFuture
      case "FeralCat" => new FeralCat
      case "MelonCat" => new MelonCat
      case "BeardedCat" => new BeardedCat
      case "TacoCat" => new TacoCat
      case "HairyPotatoCat" => new HairyPotatoCat
      case "RainbowCat" => new RainbowCat
      case "Shuffle" => new Shuffle
    }
  }
}