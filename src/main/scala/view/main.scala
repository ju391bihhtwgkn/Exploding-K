package view

import scala.::
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

    while (input != "q") {
      println(players(counter).name + " it is your turn!" + eol + "Play a Card or draw a card to end your turn" + eol)
      println("These are your cards:" + eol)
      val playercards = players(counter).handCards
      for (card <- playercards) {
        print(card + eol)
      }

      input = readLine()

      input match {
        case "q" => None
        case "d" => {
          val topCard = cdeck.takeCard()
          cdeck.reduce()
          print("Your new Card: " + topCard + eol)
          val handCardAfterDraw = players(counter).handCards ++ Vector(topCard)
          players(counter) = players(counter).copy(players(counter).name, handCardAfterDraw)

          if (topCard.name == "Exploding") {
            if (players(counter).handCards.find(_.name == "Defuse") == None) {
              players(counter).hasLost = true
              print(eol + "Sorry! " + players(counter) + " you drew an Exploding Kitten and therefore lost the game")
              input = "q"
            } else {
              print(players(counter).name + " has defused a bomb!" + eol)
            }

            counter += 1
            counter %= players.length
          }
        }
      }

      /*
    print("Du bist am zug. Möchtest du 1: eine Karte ziehen oder 2: erst die oberen drei Karten anschauen")
    val choice = readLine()
    choice match {
      case "1" => print("Your new Card: " + cdeck.takeCard())
      case "2" => print("Thats the first three Cards" + cdeck.spy())
     */
    }
  }

}
