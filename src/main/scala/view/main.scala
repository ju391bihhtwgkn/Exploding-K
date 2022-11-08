package view

import scala.util.control.Breaks._
import scala.io.StdIn.readLine

object main {
  def main(Args: Array[String]): Unit = {

    val eol = sys.props("line.separator")

    print("Welcome to Exploding Kitten!" + eol)
    print("How many players are there (2-10) ?" + eol)

    val numberOfPlayers: Int = readLine("").toInt
    val players: Array[Player] = new Array[Player](numberOfPlayers)
    var counter = 0

    for (n <- 1 to numberOfPlayers) {
      println("Player " + n + " Whats your name ?")
      val playerName: String = readLine("").toString
      players(n - 1) = Player(playerName, Vector(Card("Defuse", "testDescription"), Card("testCard2", "testDescription2")))
    }

    var input = ""

    var cdeck = Carddeck().addCard(Card("Exploding", "You die"), 2)
    cdeck = cdeck.addCard(Card("Random Card", "Do what you want"), 8)

    print("Du bist am zug. Möchtest du 1: eine Karte ziehen oder 2: erst die oberen drei Karten anschauen, keine lust mehr geb str. D ein.\n")
    while (true){
      val choice = readLine()
      choice match {
        case "1" => {print("Your new Card:\n" + cdeck.takeCardTop())
                    cdeck = cdeck.reduceTop()}
        case "2" => print("Thats the first three Cards\n" + cdeck.spy())
        case _ => {print("Spiel beendet\n")
                    break
        }
      }
    }

  }
}
