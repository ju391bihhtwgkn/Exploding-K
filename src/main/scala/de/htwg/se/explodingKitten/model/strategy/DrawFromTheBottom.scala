package de.htwg.se.explodingKitten.model.strategy

import de.htwg.se.explodingKitten.model.{Card, Gamestate, Player}

import scala.io.StdIn.readLine

class DrawFromTheBottom(i: Int) extends Move {

  var flag = false

  override def makeMove(state: Gamestate): Gamestate = {

    val currentPlayer = state.currentPlayer
    val card = state.players(currentPlayer).chooseCardToPlay(i)
    println("You played: " + card.cardName)
    val newDiscardPile = state.discardPile.appended(card)
    // Draw from the Bottom
    val newHandCards = state.players(currentPlayer).playCard(card)
    val newPlayerr = state.players.updated(currentPlayer, Player(state.players(currentPlayer).name, newHandCards))
    val newStatee = state.copy(players = newPlayerr, discardPile = newDiscardPile)
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

  def checkOnExploding(currentPlayer: Int, gameState: Gamestate): Gamestate = {
    for (n <- gameState.players(currentPlayer).handCards) if (n.cardName == Card("Defuse").cardName) {
      flag = true
    }
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