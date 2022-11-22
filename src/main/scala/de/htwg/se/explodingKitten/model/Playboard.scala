package de.htwg.se.explodingKitten.model

abstract class Playboard {

  def showHandCards(cards : Vector[Card]): String ={
    val res = ""
    cards.foreach(c => res + c + "\n")
    res
  }

  def showAction()

  def showCarddeck(deck : Carddeck) : String = deck.len().toString + "\n"

}
