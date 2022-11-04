package view

case class Carddeck() {

  var deck = Vector[Card]()

  def addCard(card:Card, anz:Int=1): Carddeck = {
    val newdeck : Carddeck = Carddeck()
    val helpVector = Vector[Card]().padTo(anz, card)
    newdeck.deck = deck ++ helpVector
    return newdeck
  }

  def len() : Int = deck.length

  def spy() : Vector[Card] = {
    if(deck.length > 2)deck.take(3)
    else deck.take(deck.length)
  }

  def takeCard() : Card = {
    deck.head
  }


  def reduce() : Carddeck ={
    val newdeck : Carddeck = Carddeck()
    newdeck.deck = deck.tail
    newdeck
  }

}
