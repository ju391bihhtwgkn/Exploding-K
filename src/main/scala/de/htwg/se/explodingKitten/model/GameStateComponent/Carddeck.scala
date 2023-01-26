package de.htwg.se.explodingKitten.model.GameStateComponent

object CardDeck {

  var deck = Vector[Card]()
  var drawnCards = Vector[Card]()

  def initializeDeck(): Unit = this.deck =
    addCard("Shuffle", 3) ++ addCard("FeralCat",3) ++
      addCard("TargetedAttack", 3) ++ addCard("ExplodingKitten",3) ++
      addCard("Skip", 3) ++ addCard("Attack", 3) ++
      addCard("DrawFromTheBottom", 3) ++ addCard("Defuse", 3) ++
      addCard("SeeTheFuture", 3)

  def addCard(cardName: String, amount: Int): Vector[Card] = {
    val helpVector = Vector[Card]().padTo(amount, Card(cardName))
    val newDeck: Vector[Card] = deck
    newDeck ++ helpVector
  }

  def reduceTop(): Vector[Card] = {
    val newdeck = deck.tail
    newdeck
  }
}