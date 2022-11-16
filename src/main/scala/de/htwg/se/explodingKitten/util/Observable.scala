package de.htwg.se.explodingKitten.util

import de.htwg.se.explodingKitten.model.{Card, Carddeck}


trait Observer {
  def update: Unit
  //def addCard: Unit
}

class Observable {
  var subscribers: Vector[Observer] = Vector()

  def add(s: Observer): Unit = subscribers = subscribers :+ s

  def remove(s: Observer): Unit = subscribers = subscribers.filterNot(o => o == s)

  def notifyObservers: Unit = subscribers.foreach(o => o.update)

}
