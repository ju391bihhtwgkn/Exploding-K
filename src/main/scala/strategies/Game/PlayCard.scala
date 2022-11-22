package strategies.Game

import de.htwg.se.explodingKitten.controller.Controller
import de.htwg.se.explodingKitten.model.{Card, Player}
import scala.io.StdIn.readLine
import scala.util.control.Breaks.break

class PlayCard extends Move {
  override def makeMove(person: Player, carddeck: Controller): Player = {
    print("Welche Karte wollen Sie spielen? Geben Sie die PlatzNr. der Karte ein:") //Tui aktivieren
    //val cNr = readLine().toInt
    val card = person.chooseCardToPlay(1)
    var newPerson = person.playCard(card)
    print(newPerson.handCards)
    card.actionCode match {
      case 2 => {
        carddeck.spy()
        newPerson
      }
      case 4 => {
        val context = new GameContext(new TakeCard)
        carddeck.deck.deck = carddeck.deck.deck.reverse
        newPerson = context.executeStrategy(newPerson, carddeck)
        carddeck.deck.deck = carddeck.deck.deck.reverse
        newPerson
      }
      case _ => {
        person
      }
    }
  }
}
