package de.htwg.se.explodingKitten.model.FileIOComponent.FileIOXmlImplementation

import de.htwg.se.explodingKitten.model.FileIOComponent.FileIOInterface
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.GameStateComponent.{Card, GameStateInterface}
import de.htwg.se.explodingKitten.model.PlayerComponent.Player


class FileIOXmlImplementation extends FileIOInterface {

  override def load(): GameStateInterface = {
    val file = scala.xml.XML.loadFile("gameState.xml")
    if( ((file \\ "gameState" \\ "playerLength").text.replace(" ", "").toInt) > 2) {
      val currentPlayer = (file \\ "gameState" \\ "currentPlayer").text.replace(" ", "").toInt
      val player1 = (file \\ "gameState" \ "player1")
      val p1Name = (player1 \\ "name").text
      val p1Cards = playerCards((player1 \\ "cards").text)
      val player2 = (file \\ "gameState" \ "player2")
      val p2Name = (player2 \\ "name").text
      val p2Cards = playerCards((player2 \\ "cards").text)
      val player3 = (file \\ "gameState" \ "player3")
      val p3Name = (player3 \\ "name").text
      val p3Cards = playerCards((player3 \\ "cards").text)
      val deck = cards((file \\ "gameState" \\ "deck" \\ "cards").text)
      val discardPile = cards((file \\ "gameState" \\ "discardPile" \\ "cards").text)

      Gamestate(currentPlayer, Vector(Player(p1Name, p1Cards), Player(p2Name, p2Cards), Player(p3Name, p3Cards)), deck, discardPile)
    } else {
      val currentPlayer = (file \\ "gameState" \\ "currentPlayer").text.replace(" ", "").toInt
      val player1 = (file \\ "gameState" \ "player1")
      val p1Name = (player1 \\ "name").text
      val p1Cards = playerCards((player1 \\ "cards").text)
      val player2 = (file \\ "gameState" \ "player2")
      val p2Name = (player2 \\ "name").text
      val p2Cards = playerCards((player2 \\ "cards").text)
      val deck = cards((file \\ "gameState" \\ "deck" \\ "cards").text)
      val discardPile = cards((file \\ "gameState" \\ "discardPile" \\ "cards").text)

      Gamestate(currentPlayer, Vector(Player(p1Name, p1Cards), Player(p2Name, p2Cards)), deck, discardPile)
    }
  }

  def cards(card: String): Vector[Card] = {
    var newCards = Vector[Card]()
    val tmp = card.split(",")
    tmp.foreach(k => {
      val m = k.trim.replace(" ", "")
      if(m != "") {
        val tmpCard = Vector(Card(m))
        newCards = newCards ++ tmpCard
      }
    })
    newCards
  }

  def playerCards(card: String): Vector[Card] = {
    val tmp = card.split(",")
    var newCards = Vector[Card]()
    tmp.foreach(k => {
      if(k != " ") {
        val tmpCard = Vector(Card(k.replace(" ", "")))
        newCards = newCards ++ tmpCard
      }
    })
    newCards
  }

  override def save(gameState: GameStateInterface): Unit = saveString(gameState)

  def saveString(gameState: GameStateInterface): Unit = {
    import java.io._
    val pw = new PrintWriter(new File("gameState.xml"))
    val prettyPrinter = new scala.xml.PrettyPrinter(120,4)
    val xml = prettyPrinter.format(gameStateToXml(gameState))
    pw.write(xml)
    pw.close
  }

  def gameStateToXml(gameState: GameStateInterface) = {
    if(gameState.players.length > 2) {
      <gameState>
        <currentPlayer>
          {gameState.currentPlayer.toString}
        </currentPlayer>
        <playerLength>
          {gameState.players.length.toString}
        </playerLength>
        <player1>
          {playerToXml(gameState.players(0))}
        </player1>
        <player2>
          {playerToXml(gameState.players(1))}
        </player2>
        <player3>
          {playerToXml(gameState.players(1))}
        </player3>
        <deck>
          {cardsToXml(gameState.deck)}
        </deck>
        <discardPile>
          {cardsToXml(gameState.discardPile)}
        </discardPile>
      </gameState>
    } else {
      <gameState>
        <currentPlayer>
          {gameState.currentPlayer.toString}
        </currentPlayer>
        <playerLength>
          {gameState.players.length.toString}
        </playerLength>
        <player1>
          {playerToXml(gameState.players(0))}
        </player1>
        <player2>
          {playerToXml(gameState.players(1))}
        </player2>
        <deck>
          {cardsToXml(gameState.deck)}
        </deck>
        <discardPile>
          {cardsToXml(gameState.discardPile)}
        </discardPile>
      </gameState>
    }
  }

  def playerToXml(player: Player) = {
    <player>
      <name>{player.name}
      </name>
      <cards>{player.handCards.map(k => k.cardName + ",")}
      </cards>
      <cardLength>{player.handCards.length.toString}
      </cardLength>
    </player>
  }

  def cardsToXml(cards: Vector[Card]) = {
    <cards>{cards.map(k => k.cardName + ",")}
    </cards>
  }
}
