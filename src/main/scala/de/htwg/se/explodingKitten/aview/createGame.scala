package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.ControllerInterface
import de.htwg.se.explodingKitten.controller.controllerBaseImplementation.Controller

import javax.swing.BorderFactory
import scala.swing.event.ButtonClicked
import scala.swing.{Button, Dimension, GridPanel, Label, Orientation, TextArea}

case class createGame(controller: ControllerInterface) {
  val label1 = new Label("Player 1 - Enter your Name below") {
    maximumSize = new Dimension(30, 5)
    minimumSize = new Dimension(30, 5)
  }
  val player1 = new TextArea() {
    border = BorderFactory.createRaisedBevelBorder();
    minimumSize = new Dimension(50, 10)
    maximumSize = new Dimension(50, 10)
  }
  val label2 = new Label("Player 2 - Enter your Name below") {
    maximumSize = new Dimension(30, 5)
    minimumSize = new Dimension(30, 5)
  }
  val player2 = new TextArea() {
    border = BorderFactory.createRaisedBevelBorder();
    minimumSize = new Dimension(50, 10)
    maximumSize = new Dimension(50, 10)

  }
  val label3 = new Label("Player 3 - Enter your Name below") {
    maximumSize = new Dimension(30, 5)
    minimumSize = new Dimension(30, 5)
  }
  val player3 = new TextArea() {
    border = BorderFactory.createRaisedBevelBorder();
    minimumSize = new Dimension(50, 10)
    maximumSize = new Dimension(50, 10)
  }

  val startButton = new Button("Start Game") {
    reactions += { case ButtonClicked(_) =>
      controller.initializeDeck()
      controller.createPlayers(List(player1.text, player2.text, player3.text))
      controller.initializePlayers(controller.gameState.players)
    }

    border = BorderFactory.createRaisedBevelBorder();
    minimumSize = new Dimension(50, 10)
    maximumSize = new Dimension(50, 10)
  }

  def start: GridPanel = new GridPanel(7 , 1) {
    contents += label1
    contents += player1
    contents += label2
    contents += player2
    contents += label3
    contents += player3
    contents += startButton
    minimumSize = new Dimension(500, 500)
    maximumSize = new Dimension(500, 500)
    preferredSize = new Dimension(500, 500)
  }
}
