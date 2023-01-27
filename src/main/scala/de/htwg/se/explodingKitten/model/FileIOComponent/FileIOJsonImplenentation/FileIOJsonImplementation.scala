package de.htwg.se.explodingKitten.model.FileIOComponent.FileIOJsonImplenentation

import de.htwg.se.explodingKitten.model.FileIOComponent.FileIOInterface
import de.htwg.se.explodingKitten.model.GameStateComponent.GameStateBaseimplementation.Gamestate
import de.htwg.se.explodingKitten.model.GameStateComponent.{Card, GameStateInterface}
import de.htwg.se.explodingKitten.model.PlayerComponent.Player
import play.api.libs.json.{JsObject, JsValue, Json}

import java.io.{File, PrintWriter}
import scala.io.Source

class FileIOJsonImplementation extends FileIOInterface {

  override def load: GameStateInterface = {
    val source: String = Source.fromFile("gameState.json").getLines().mkString
    val json: JsValue = Json.parse(source)

    val playerLength = (json \ "gameState" \ "playerLength").get.as[String].toInt

    if(playerLength > 2) {
      val currentPlayer = (json \ "gameState" \ "currentPlayer").get.as[String].toInt
      val p1Name = (json \ "gameState" \ "player 1" \ "name").get.as[String]
      val p1Cards = Cards(json, "player 1", "cardLength")
      val p2Name = (json \ "gameState" \ "player 2" \ "name").get.as[String]
      val p2Cards = Cards(json, "player 2", "cardLength")
      val p3Name = (json \ "gameState" \ "player 3" \ "name").get.as[String]
      val p3Cards = Cards(json, "player 3", "cardLength")
      val deck = Cards(json, "deck", "cardLength")
      val discardPile = Cards(json, "discardPile", "cardLength")

      Gamestate(currentPlayer,Vector(Player(p1Name, p1Cards),Player(p2Name, p2Cards),Player(p3Name, p3Cards)), deck, discardPile)

    } else {
      val currentPlayer = (json \ "gameState" \ "currentPlayer").get.as[String].toInt
      val p1Name = (json \ "gameState" \ "player 1" \ "name").get.as[String]
      val p1Cards = Cards(json, "player 1", "cardLength")
      val p2Name = (json \ "gameState" \ "player 2" \ "name").get.as[String]
      val p2Cards = Cards(json, "player 2", "cardLength")
      val deck = Cards(json, "deck", "cardLength")
      val discardPile = Cards(json, "discardPile", "cardLength")

      Gamestate(currentPlayer,Vector(Player(p1Name, p1Cards),Player(p2Name, p2Cards)), deck, discardPile)
    }
  }

  def Cards(json: JsValue, player: String, length: String): Vector[Card] = {
    var newCards = Vector[Card]()
    for(i <- 0 to ((json \ "gameState" \ player \ length).get.as[String].toInt - 1)) {
      val card = Vector(Card((json \ "gameState" \ player \ "cards").get(i).as[String].replace(" ", "")))
      newCards = newCards ++ card
    }
    newCards
  }

  override def save(gameState: GameStateInterface): Unit = {

    val pw = new PrintWriter(new File("Gamestate.json"))

    pw.write(Json.prettyPrint(gameStateToJson(gameState)))
    pw.close()

    def gameStateToJson(gameState: GameStateInterface): JsObject = {
      if(gameState.players.length > 2) {
      Json.obj(
        "gameState" -> Json.obj(
          "currentPlayer" -> gameState.currentPlayer.toString,
          "playerLength" -> gameState.players.length.toString,
          "player 1" -> Json.obj(
            "name" -> gameState.players(0).name,
            "cards" -> gameState.players(0).handCards.map(k => k.cardName),
            "cardLength" -> gameState.players(0).handCards.length.toString
          ),
          "player 2" -> Json.obj(
            "name" -> gameState.players(1).name,
            "cards" -> gameState.players(1).handCards.map(k => k.cardName),
            "cardLength" -> gameState.players(1).handCards.length.toString
          ),
          "player 3" -> Json.obj(
            "name" -> gameState.players(2).name,
            "cards" -> gameState.players(2).handCards.map(k => k.cardName),
            "cardLength" -> gameState.players(2).handCards.length.toString
          ),
          "deck" -> Json.obj(
            "cards" -> gameState.deck.map(k => k.cardName),
            "cardLength" -> gameState.deck.length.toString
          ),
          "discardPile" -> Json.obj(
            "cards" -> gameState.discardPile.map(k => k.cardName),
            "cardLength" -> gameState.discardPile.length.toString
          )
        )
      )
    } else {
        Json.obj(
          "gameState" -> Json.obj(
            "currentPlayer" -> gameState.currentPlayer.toString,
            "playerLength" -> gameState.players.length.toString,
            "player 1" -> Json.obj(
              "name" -> gameState.players(0).name,
              "cards" -> gameState.players(0).handCards.map(k => k.cardName),
              "cardLength" -> gameState.players(0).handCards.length.toString
            ),
            "player 2" -> Json.obj(
              "name" -> gameState.players(1).name,
              "cards" -> gameState.players(1).handCards.map(k => k.cardName),
              "cardLength" -> gameState.players(1).handCards.length.toString
            ),
            "deck" -> Json.obj(
              "cards" -> gameState.deck.map(k => k.cardName),
              "cardLength" -> gameState.deck.length.toString
            ),
            "discardPile" -> Json.obj(
              "cards" -> gameState.discardPile.map(k => k.cardName),
              "cardLength" -> gameState.discardPile.length.toString
            )
          )
        )
      }
    }
  }
}
