package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.model.{Card, Gamestate, Player}

class TakeCard extends Move {

  override def makeMove(state: Gamestate): Gamestate = {
    // get top card
    val tempCard = state.deck.head
    println(state.players(state.currentPlayer).name + " you have drawn this card: " + tempCard.cardName + "\n")
    // remove top card
    val newDeck = state.deck.drop(1)
    // new state for player
    val newPlayer = state.players.updated(state.currentPlayer, Player(state.players(state.currentPlayer).name
      , state.players(state.currentPlayer).handCards.appended(tempCard)))
    if(tempCard.cardName == Card("ExplodingKitten").cardName) {
      val afterCheckState = checkOnExploding(state.currentPlayer, tempCard, state)
        if (afterCheckState.players.length == 1) {
          println("Congratulations " + afterCheckState.players(0).name + " you have won the Game")
          System.exit(0)
        }
      return afterCheckState
    }
    val newState = state.copy(deck = newDeck, players = newPlayer)
    //println(newState.players(state.currentPlayer).name + " Deine handkarten \n" + newState.players(state.currentPlayer).handCards)
    newState
  }

  def checkOnExploding(currentPlayer : Int, tempCard : Card, gamestate: Gamestate): Gamestate = {
      if (gamestate.players(currentPlayer).handCards.contains(Card("Defuse"))) {
        gamestate
        // TODO: Put Exploding into deck, if he has defuse
        //carddeck.hideCardInDeck(explCard, 2)
        //return person.playCard(Card("Defuse"))
      } else {
        gamestate.players(gamestate.currentPlayer).setHasLost()
        println(gamestate.players(currentPlayer).name + "You have lost :(")
        val newPlayers = gamestate.players.patch(currentPlayer, Nil, 1)
        val newState = gamestate.copy(players = newPlayers)
        println(newState.players)
        newState
      }
  }
}

