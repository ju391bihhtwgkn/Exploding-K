package view

import model.Player

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
      players(n - 1) = Player(playerName, List(Card("Defuse", "test"), Card("test2", "test2")))
    }

    var input = ""
    var deck = DrawPile.createDeck()

    while (input != "q") {

      println(players(counter).name + " it is your turn!" + eol + "Play a Card or draw a card to end your turn")
      println("These are your cards:" + eol)
      val playercards = players(counter).handCards
      for (card <- playercards) {
        print(card + eol)
      }

      input = readLine()

      input match {
        case "q" => None

        case "d" => {
          val topCard = deck.head
          val dropTopCard = deck.drop(1)
          val handCardsAfterDraw = topCard :: players(counter).handCards

          players(counter) = players(counter).copy(players(counter).name, handCardsAfterDraw)

          if(topCard.name == "Exploding Kitten") {
            if (players(counter).handCards.find(_.name == "Defuse") == None) {
              players(counter).hasLost = true
              print("Sorry! " + players(counter) + " you drew an Exploding Kitten and therefore lost the game")
              input = "q"
            } else {
              print(players(counter).name + " has defused a bomb!")
            }
          }

          counter +=1
          counter %= players.length
          deck = dropTopCard
        }
      }
    }
  }
}