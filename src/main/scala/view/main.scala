package view

import scala.io.StdIn.readLine

object main {
  def main(Args: Array[String]): Unit = {
    var cdeck = Carddeck().addCard(Card("Exploding", "You die"), 2)
    cdeck = cdeck.addCard(Card("Random Card", "Do what you want"), 8)
    print("Du bist am zug. Möchtest du 1: eine Karte ziehen oder 2: erst die oberen drei Karten anschauen")
    val choice = readLine()
    choice match {
      case "1" => print("Your new Card: " + cdeck.takeCard())
      case "2" => print("Thats the first three Cards" + cdeck.spy())
    }
  }

}
