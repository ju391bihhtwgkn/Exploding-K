package de.htwg.se.explodingKitten

import de.htwg.se.explodingKitten.aview.{Gui, Tui}
import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.cardComponent.cardImpl.Carddeck


object ExplodingKitten {

  //val controller = new Controller(Carddeck().addCard(Card("FeralCat"), 2).addCard(Card("ExplodingKitten")).addCard(Card("DrawFromTheBottom"), 2))
  val controller = new Controller()
  val tui = new Tui(controller)
//  controller.notifyObservers

  def main(args: Array[String]): Unit = {
      val gui =  new Gui(controller)
      while(true) {
        tui.processInputLine()
      }
      }

  //Karten Anzeigen
  //Karte Ziehen oder Legen
  //1.1 Ziehe
  //1.2 Check ob Exploding
  //1.2.1 Check ob extra leben
  //1.2.1.1 Lege extra Leben
  //1.2.1.1.1 Lege Karte zurück in den Stapel
  //1.2.1.2 Tod, Spieler raus
  //1.3 Nächtser ist dran
  //2.1 Lege
  //2.2 Wähle Karte aus und entferne sie aus den karten
  //2.3 Führe Aktion durch
  //2.3.1 Kann Karte Ziehen, abbruch des Spielzuges, Mischen, Anschauen von Karten, Abwehr(darf man noch mal legen danach) beinhalten
  //2.4 Nächster ist dran
}
