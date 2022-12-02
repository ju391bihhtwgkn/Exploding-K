package de.htwg.se.explodingKitten.model

import de.htwg.se.explodingKitten.controller.Controller

class UndoCard extends Move {

  override def makeMove(person : Player, carddeck : Controller): Player = {
    val tempCard = carddeck.takeTopCard()
    println("You have drawn this Card: " + tempCard)
    carddeck.reduceTop()
    val p = checkOnExploding(person, carddeck, tempCard)
    if (p.hasLost){
      return p}
    person.takeCard(tempCard)
  }
}
