package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface

import java.awt.{Color}
import javax.swing.BorderFactory
import scala.swing.event.ButtonClicked
import scala.swing.{Button, Dimension, Font, GridPanel, Label, TextArea}

case class createGame(controller: ControllerInterface) {
  val label1 : Label = new Label("Player 1 - Enter your Name below") {
    font = new Font("Arial", 1, 13)
    border = BorderFactory.createLineBorder(Color.black)
    maximumSize = new Dimension(50, 5)
    minimumSize = new Dimension(50, 5)
    preferredSize = new Dimension(50, 5)

  }
  val player1 : TextArea = new TextArea() {
    font = new Font("Arial", 1, 13)
    border = BorderFactory.createEmptyBorder(10,10,10,10)
    maximumSize = new Dimension(50, 5)
    minimumSize = new Dimension(50, 5)
    preferredSize = new Dimension(50, 5)
  }
  val label2 : Label = new Label("Player 2 - Enter your Name below") {
    font = new Font("Arial", 1, 13)
    border = BorderFactory.createLineBorder(Color.black)
    maximumSize = new Dimension(50, 5)
    minimumSize = new Dimension(50, 5)
    preferredSize = new Dimension(50, 5)
  }
  val player2 : TextArea = new TextArea() {
    font = new Font("Arial", 1, 13)
    border = BorderFactory.createEmptyBorder(10,10,10,10)
    maximumSize = new Dimension(50, 5)
    minimumSize = new Dimension(50, 5)
    preferredSize = new Dimension(50, 5)

  }
  val label3 : Label = new Label("Player 3 - Enter your Name below") {
    font = new Font("Arial", 1, 13)
    border = BorderFactory.createLineBorder(Color.black)
    maximumSize = new Dimension(50, 5)
    minimumSize = new Dimension(50, 5)
    preferredSize = new Dimension(50, 5)
  }
  val player3: TextArea = new TextArea() {
    font = new Font("Arial", 1, 13)
    border = BorderFactory.createEmptyBorder(10,10,10,10)
    maximumSize = new Dimension(50, 5)
    minimumSize = new Dimension(50, 5)
    preferredSize = new Dimension(50, 5)
  }

  val startButton : Button = new Button("Start Game") {
    reactions += { case ButtonClicked(_) =>
      controller.initializeDeck()
      controller.createPlayers(List(player1.text, player2.text, player3.text))
      controller.initializePlayers(controller.gameState.players)
    }

    border = BorderFactory.createRaisedBevelBorder()
    maximumSize = new Dimension(50, 5)
    minimumSize = new Dimension(50, 5)
    preferredSize = new Dimension(50, 5)
  }

  def start: GridPanel = new GridPanel(7 , 1) {
    contents += label1
    contents += player1
    contents += label2
    contents += player2
    contents += label3
    contents += player3
    contents += startButton
    font = new Font("Arial", 1, 30)
    border = BorderFactory.createEmptyBorder(10,10,10,10)
    minimumSize = new Dimension(400, 400)
    maximumSize = new Dimension(400, 400)
    preferredSize = new Dimension(400, 400)
  }
}
