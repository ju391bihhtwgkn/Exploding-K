package de.htwg.se.explodingKitten.model.StrategyComponent

import de.htwg.se.explodingKitten.model.GameStateComponent.Card
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.PlayerComponent.Player

class TakeExploding(i : Int) extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {
    val currentPlayer = state.currentPlayer

    // Remove Exploding Kitten from Deck
    val newDeck = state.deck.drop(1)
    println(state.players(currentPlayer).name + " you have drawn a " + Card("ExplodingKitten").cardName + "\n")

    // Check for Defuse Card
    for (n <- state.players(currentPlayer).handCards) if (n.cardName == Card("Defuse").cardName) flag = true

    val idx = state.players(currentPlayer).handCards.indexWhere(Card => Card.cardName == "Defuse")

    if(flag == true) {
      // remove Defuse Card from PlayerHand
      val card = state.players(currentPlayer).handCards(idx)
      println(state.players(state.currentPlayer))
      val newHandCards = state.players(state.currentPlayer).playCard(card)
      val newPlayers = state.players.updated(currentPlayer, Player(state.players(state.currentPlayer).name
        , newHandCards))
      val newState = state.copy(deck = newDeck, players = newPlayers)

      // put Exploding Kitten back into Deck
      if (0 < i && i <= newState.deck.length) {
        val (front, back) = newState.deck.splitAt(i)
        val newDeck = front ++ Vector(Card("ExplodingKitten")) ++ back
        val newState2 = newState.copy(deck = newDeck)
        newState2
    } else {
        println("invalid Number")
        state
      }
  } else {
      println(state.players(currentPlayer).name + "You have lost :(")
      val newPlayers = state.players.patch(currentPlayer, Nil, 1)
      val newState = state.copy(players = newPlayers, currentPlayer = currentPlayer - 1)
      newState
    }
  }
  flag = false
}