package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.model.{Card, Gamestate, Player}

import scala.io.StdIn.{readInt, readLine}

class PlayCard(i: Int) extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {

    val currentPlayer = state.currentPlayer
    val card = state.players(currentPlayer).chooseCardToPlay(i)
    println("You played: " + card.cardName)


      card.actionCode match {
        case 1 => {
          new DrawFromTheBottom(i).makeMove(state)
        }
        case 5 => {
          new TargetedAttack(i, 1).makeMove(state)
        }
          // Draw from the Bottom
          /*
          val newHandCards = state.players(currentPlayer).playCard(card)
          val newPlayerr = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
          val newStatee = state.copy(players = newPlayerr)
          val tempCard = state.deck.last
          println(state.players(state.currentPlayer).name + " you have drawn this card: \n" + tempCard + "\n")
          val newDeck = state.deck.dropRight(1)
          val newPlayer = newStatee.players.updated(newStatee.currentPlayer, Player(newStatee.players(newStatee.currentPlayer).name
            , newStatee.players(newStatee.currentPlayer).handCards.appended(tempCard)))
          if (tempCard.cardName == Card("ExplodingKitten").cardName) {
            val afterCheckState = checkOnExploding(state.currentPlayer, state)
            if (afterCheckState.players.length == 1) {
              println("Congratulations " + afterCheckState.players(0).name + " you have won the Game")
              System.exit(0)
            }
            return afterCheckState
          }
          val newState = newStatee.copy(deck = newDeck, players = newPlayer)
          newState
        }

           */
        // See the Future
        case 2 => {
          val newHandCards = state.players(currentPlayer).playCard(card)
          val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
          val newState = state.copy(players = newPlayer)

          if (newState.deck.length > 2) {
            val topCards = newState.deck.take(3)
            println(topCards)
            newState
          } else {
            val topCards = newState.deck.take(newState.deck.length)
            println(topCards)
            newState
          }
        }
        // Skip
        case 3 => {
          val newHandCards = state.players(currentPlayer).playCard(card)
          val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
          val nextPlayerState = state.copy(players = newPlayer)
          if (nextPlayerState.currentPlayer == 0) {
            val nextPlayer = nextPlayerState.currentPlayer + 1
            val newState = state.copy(currentPlayer = nextPlayer)
            newState
          } else if (nextPlayerState.currentPlayer == 1) {
            val nextPlayer = nextPlayerState.currentPlayer + 1
            val newState = state.copy(currentPlayer = nextPlayer)
            newState
          } else {
            val nextPlayer = nextPlayerState.currentPlayer - 2
            val newState = state.copy(currentPlayer = nextPlayer)
            newState
          }
        }
        // Attack
        case 4 => {
          val newHandCards = state.players(currentPlayer).playCard(card)
          val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
          val nextPlayerState = state.copy(players = newPlayer)
          if (nextPlayerState.currentPlayer == 0) {
            val nextPlayer = nextPlayerState.currentPlayer + 1
            println(nextPlayer)
            val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
            newState
          } else if (nextPlayerState.currentPlayer == 1) {
            val nextPlayer = nextPlayerState.currentPlayer + 1
            val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
            newState
          } else {
            val nextPlayer = nextPlayerState.currentPlayer + 1
            val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
            newState
          }
        }
        // Targeted attack
        case 5 => {
          val newHandCards = state.players(currentPlayer).playCard(card)
          val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
          val nextPlayerState = state.copy(players = newPlayer)
          val otherPlayers = state.players.filterNot(x => {
            x.name == state.players(currentPlayer).name
          })
          println("Choose a player to draw a card from\n" + otherPlayers)
          val input = readInt()
          input match {
            case 1 => {
              if (nextPlayerState.currentPlayer == 0) {
                val nextPlayer = nextPlayerState.currentPlayer + 1
                val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
                newState
              } else if (nextPlayerState.currentPlayer == 1) {
                val nextPlayer = nextPlayerState.currentPlayer - 1
                val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
                newState
              } else {
                val nextPlayer = nextPlayerState.currentPlayer - 2
                val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
                newState
              }
            }
            case 2 => {
              if (nextPlayerState.currentPlayer == 0) {
                val nextPlayer = nextPlayerState.currentPlayer + 2
                val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
                newState
              } else if (nextPlayerState.currentPlayer == 1) {
                val nextPlayer = nextPlayerState.currentPlayer + 1
                val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
                newState
              } else {
                val nextPlayer = nextPlayerState.currentPlayer - 1
                val newState = nextPlayerState.copy(currentPlayer = nextPlayer)
                newState
              }
            }
            case 6 => {
              println("You cannot play the Defuse Card! Choose another card.")
              state
            }
          }
        }
      }
  }

  def checkOnExploding(currentPlayer: Int, gameState: Gamestate): Gamestate = {
    for (n <- gameState.players(currentPlayer).handCards) if (n.cardName == Card("Defuse").cardName) {
      flag = true
    }
    println(flag)
    if (flag == true) {
      val newHandCards = gameState.players(currentPlayer).playCard(Card("Defuse"))
      val newPlayer = gameState.players.updated(currentPlayer, Player(gameState.players(currentPlayer).name, newHandCards))
      println("Where do you want to put the Exploding Kitten into the deck?")
      println("Choose from " + "1 to " + gameState.deck.length)
      val input = readLine().toInt
      input match {
        case x if (0 <= x && x < gameState.deck.length) =>
          val (front, back) = gameState.deck.splitAt(input)
          val newDeck = front ++ Vector(Card("ExplodingKitten")) ++ back
          val newState = gameState.copy(deck = newDeck, players = newPlayer)
          newState
        case _ => println("Choose a allowed Place")
          gameState
      }
    } else {
      gameState.players(gameState.currentPlayer).setHasLost()
      println(gameState.players(currentPlayer).name + "You have lost :(")
      val newPlayers = gameState.players.patch(currentPlayer, Nil, 1)
      val newState = gameState.copy(players = newPlayers)
      println(newState.players)
      newState
    }
  }
}

    /*
      /*
      case 9 => {
      // Cat Cards bei 2 von spieler ziehen, bei 3 bestimmte karte von spieler wünschen
        var nCards = 0
        //val cards = Vector[Card]
        for ( n <- state.players(currentPlayer).handCards) if (n.cardName == Card("FeralCat").cardName) nCards += 1
        if (nCards > 2) {
          println("Choose a Card and a Player you want to draw a card from \n")
          state.players(currentPlayer).playCard(Card("FeralCat"))
          val newHandCards = state.players(currentPlayer).playCard(Card("FeralCat"))
          val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))

          val newState = state.copy(players = newPlayer)
          newState
        } else if (nCards == 2) {
          println("Choose a Player to draw a Card from \n")
          val newHandCards = state.players(currentPlayer).playCard(Card("FeralCat"))
          val newPlayer = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
          val input = readLine()
          input match {
            case  =>
          }

          val newState = state.copy(players = newPlayer)
          newState
        } else {
          println("Hallo2")
          state
        }

       */
        //def spy(): Vector[Card] = {
        //  if (deck.length > 2) deck.take(3)
        //  else
        //    deck.take(deck.length)
        //newPerson
      }
      //case 4 => {
      //val context = new GameContext(new TakeCard)
      //carddeck.deck.deck = carddeck.deck.deck.reverse
      //newPerson = context.executeStrategy(newPerson, carddeck)
      //carddeck.deck.deck = carddeck.deck.deck.reverse
      //newPerson
      //}
      //case _ => {
      //newPerson
      //}
    }
    //}
  }
}
     */