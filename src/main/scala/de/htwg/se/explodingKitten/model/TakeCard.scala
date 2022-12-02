package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.Player


class TakeCard extends Move {

  override def makeMove(person : Player, carddeck : Controller): Player = {
    val tempCard = carddeck.takeTopCard()
    println("You have drawn this Card: " + tempCard)
    carddeck.reduceTop()
    val p = checkOnExploding(person, carddeck, tempCard)
    if (p.hasLost){
      return p}
    person.takeCard(tempCard)
  }

  def checkOnExploding(person : Player, carddeck : Controller, tempCard : Card): Player ={
    if(tempCard == Card("ExplodingKitten")) {
      if (person.handCards.contains(Card("Defuse"))) {
        //Abfrage wo die Karte versteckt werden soll
        //carddeck.hideCardInDeck(explCard, 2)
        return person.playCard(Card("Defuse"))
      }
      person.setHasLost()
    }
    person
  }
}

class newMove extends Move{
  override def makeMove(person: Player, carddeck: Controller): Player = person
}
