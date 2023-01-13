package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.{Controller, GameContext}
import de.htwg.se.explodingKitten.model.Card
import de.htwg.se.explodingKitten.model.strategy.{Attack, DrawFromTheBottom, NextPlayer, PlayCard, SeeTheFuture, Skip, TakeCard, TargetedAttack}

import java.awt.{Color, Point}
import javax.swing.{BorderFactory, Box, ImageIcon}
import scala.swing.Alignment.{Center, Top}
import scala.swing.event.{ButtonClicked, MouseClicked}
import scala.swing.{BoxPanel, Button, Dimension, Font, GridBagPanel, GridPanel, Insets, Label, Menu, Orientation, PopupMenu}

case class GuiElements(controller: Controller) {

  val context = new GameContext(null)
  var popup = new PopupMenu
  var seeFuturePopUp = new PopupMenu

  def gridBagPanel: GridBagPanel = new GridBagPanel {
    def constraints(x: Int, y: Int,
                    gridwidth: Int = 1, gridheight: Int = 1,
                    fill: GridBagPanel.Fill.Value = GridBagPanel.Fill.None)
    : Constraints = {
      val c = new Constraints
      c.gridx = x
      c.gridy = y
      c.gridwidth = gridwidth
      c.gridheight = gridheight
      c.fill = fill
      c
    }
    //preferredSize = new Dimension(600, 300)
    //val player = controller.gameState.players(controller.gameState.currentPlayer)
    //val playerLabel = new Label(player.name)
    //add(playerLabel, constraints(1,0,gridheight = 2, fill = GridBagPanel.Fill.Both))
    add(label, constraints(3, 0, fill = GridBagPanel.Fill.Vertical))
    add(handCards, constraints(1, 1, gridheight = 2, fill = GridBagPanel.Fill.Horizontal))
    add(deck, constraints(3, 1, gridheight = 1))
    add(disCardPile, constraints(3, 2, gridheight = 1))
    add(undo, constraints(0 ,0, gridheight = 1, gridwidth = 1))
    add(redo, constraints(0, 1, gridheight = 1, gridwidth = 1))
  }

  def label : Label = new Label(controller.gameState.deck.length.toString) {
    font = new Font(Font.Serif, 1, 30)
  }

  def deck : Button = new Button() {
    reactions += { case ButtonClicked(_) =>
      context.setStrategy(new TakeCard())
      context.executeStrategy(controller)

      context.setStrategy(new NextPlayer())
      context.executeStrategy(controller)
    }
    preferredSize = new Dimension(250, 380)
    icon = new ImageIcon("src/ressources/CardBack.PNG")
  }

  def disCardPile: Button = new Button() {
    val card = controller.gameState.discardPile.last
      icon = card.cardName match {
        case "Draw from the Bottom" => new ImageIcon("src/ressources/DrawFromTheBottom.PNG")
        case "See the Future" => new ImageIcon("src/ressources/SeeTheFuture.PNG")
        case "Skip" => new ImageIcon("src/ressources/Skip.PNG")
        case "Attack" => new ImageIcon("src/ressources/Attack.PNG")
        case "Targeted Attack" => new ImageIcon("src/ressources/TargetedAttack.PNG")
        case "Defuse" => new ImageIcon("src/ressources/Defuse.PNG")
        case "Exploding Kitten" => new ImageIcon("src/ressources/ExplodingKitten.PNG")
        case "Alter the Future" => new ImageIcon("src/ressources/AlterTheFuture.PNG")
        case "Feral Cat" => new ImageIcon("src/ressources/FerealCat.PNG")
        case "Melon Cat" => new ImageIcon("src/ressources/MelonCat.PNG")
        case "Bearded Cat" => new ImageIcon("src/ressources/BeardedCat.PNG")
        case "Taco Cat" => new ImageIcon("src/ressources/TacoCat.PNG")
        case "Hairy Potato Cat" => new ImageIcon("src/ressources/HairyPotatoCat.PNG")
        case "Rainbow Cat" => new ImageIcon("src/ressources/RainbowCat.PNG")
      }
      preferredSize = new Dimension(250, 380)
    }

  //controller.initializeDeck()
  //controller.createPlayers(List("hallo", "Hallo2", "Hi"))
  //controller.initializePlayers(controller.gameState.players)
  //println(controller.gameState.players)
  def handCards : GridBagPanel = new GridBagPanel {
    def constraints(x: Int, y: Int,
                    gridwidth: Int, gridheight: Int,
                    fill: GridBagPanel.Fill.Value = GridBagPanel.Fill.None,
                    insets: Insets
                   )
    : Constraints = {
      val c = new Constraints
      c.gridx = x
      c.gridy = y
      c.gridwidth = gridwidth
      c.gridheight = gridheight
      c.fill = fill
      c.insets = insets
      c
    }
    preferredSize = new Dimension(1000, 599)

    if (controller.gameState.players != null) {
      val player = controller.gameState.players(controller.gameState.currentPlayer)
      val label = new Label(player.name)
      label.preferredSize = new Dimension(100, 40)
      label.font = new Font(Font.Serif, 1, 20)
      label.verticalAlignment = Top
      add(label, constraints(1, 0, gridheight = 1, gridwidth = 2, insets = new Insets(0, 0, 0, 0)))
      var x = 1
      var b = 1
      for (i <- 0 to player.handCards.length - 1) {
          add(new Button() {
            icon = player.handCards(i).cardName match {
              case "Draw from the Bottom" => new ImageIcon("src/ressources/DrawFromTheBottom.PNG")
              case "See the Future" => new ImageIcon("src/ressources/SeeTheFuture.PNG")
              case "Skip" => new ImageIcon("src/ressources/Skip.PNG")
              case "Attack" => new ImageIcon("src/ressources/Attack.PNG")
              case "Targeted Attack" => new ImageIcon("src/ressources/TargetedAttack.PNG")
              case "Defuse" => new ImageIcon("src/ressources/Defuse.PNG")
              case "Exploding Kitten" => new ImageIcon("src/ressources/ExplodingKitten.PNG")
              case "Alter the Future" => new ImageIcon("src/ressources/AlterTheFuture.PNG")
              case "Feral Cat" => new ImageIcon("src/ressources/FerealCat.PNG")
              case "Melon Cat" => new ImageIcon("src/ressources/MelonCat.PNG")
              case "Bearded Cat" => new ImageIcon("src/ressources/BeardedCat.PNG")
              case "Taco Cat" => new ImageIcon("src/ressources/TacoCat.PNG")
              case "Hairy Potato Cat" => new ImageIcon("src/ressources/HairyPotatoCat.PNG")
              case "Rainbow Cat" => new ImageIcon("src/ressources/RainbowCat.PNG")
            }
            preferredSize = new Dimension(100, 200)
            border = BorderFactory.createLineBorder(Color.BLACK, 2, true)
            listenTo(mouse.clicks)
            reactions += { case a: MouseClicked =>
              player.handCards(i).actionCode match {
                case 1 =>
                  context.setStrategy(new DrawFromTheBottom(i + 1))
                  context.executeStrategy(controller)
                  context.setStrategy(new NextPlayer())
                  context.executeStrategy(controller)
                case 2 =>
                  seeFuturePopUp = SeeFuturePopUp(i)
                  seeFuturePopUp.visible = true
                case 3 =>
                  context.setStrategy(new Skip(i))
                  context.executeStrategy(controller)
                case 4 =>
                  context.setStrategy(new Attack(i))
                  context.executeStrategy(controller)
                case 5 => {
                  popup = popupMenu(i)
                  popup.visible = true
                }
              }
            }
          }, constraints(i % 4, x, gridheight = 1, gridwidth = 1, insets = new Insets(2, 2, 2, 2)))
        b += 1
        if (b > 4) {
          x += 1
          b = 0
        }
      }
    }
  }
  def popupMenu(i: Int): PopupMenu = new PopupMenu {
    val otherPlayers = controller.gameState.players.filterNot(x => {
      x.name == controller.gameState.players(controller.gameState.currentPlayer).name
    })
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Button() {
        preferredSize = new Dimension(200, 200)
        text = otherPlayers(0).name
        reactions += { case ButtonClicked(_) =>
          context.setStrategy(new TargetedAttack(i, 1))
          context.executeStrategy(controller)
          popup.visible = false
        }
      }
      contents += new Button() {
        preferredSize = new Dimension(200, 200)
        text = otherPlayers(1).name
        reactions += { case ButtonClicked(_) =>
          context.setStrategy(new TargetedAttack(i, 2))
          context.executeStrategy(controller)
          popup.visible = false
        }
      }
    }
  }

  var topCards:Vector[Card] = Vector()

  def SeeFuturePopUp(i: Int): PopupMenu = new PopupMenu {
    preferredSize = new Dimension(800, 400)
    if (controller.gameState.deck.length > 2) {
      topCards = controller.gameState.deck.take(3)
    } else {
      topCards = controller.gameState.deck.take(controller.gameState.deck.length)
    }
    contents += new BoxPanel(Orientation.Horizontal) {
      preferredSize = new Dimension(500, 200)
      for (n <- 0 until topCards.length) {
      contents += new Button() {
        icon = topCards(n).cardName match {
          case "Draw from the Bottom" => new ImageIcon("src/ressources/DrawFromTheBottom.PNG")
          case "See the Future" => new ImageIcon("src/ressources/SeeTheFuture.PNG")
          case "Skip" => new ImageIcon("src/ressources/Skip.PNG")
          case "Attack" => new ImageIcon("src/ressources/Attack.PNG")
          case "Targeted Attack" => new ImageIcon("src/ressources/TargetedAttack.PNG")
          case "Defuse" => new ImageIcon("src/ressources/Defuse.PNG")
          case "Exploding Kitten" => new ImageIcon("src/ressources/ExplodingKitten.PNG")
          case "Alter the Future" => new ImageIcon("src/ressources/AlterTheFuture.PNG")
          case "Feral Cat" => new ImageIcon("src/ressources/FerealCat.PNG")
          case "Melon Cat" => new ImageIcon("src/ressources/MelonCat.PNG")
          case "Bearded Cat" => new ImageIcon("src/ressources/BeardedCat.PNG")
          case "Taco Cat" => new ImageIcon("src/ressources/TacoCat.PNG")
          case "Hairy Potato Cat" => new ImageIcon("src/ressources/HairyPotatoCat.PNG")
          case "Rainbow Cat" => new ImageIcon("src/ressources/RainbowCat.PNG")
        }
        preferredSize = new Dimension(100, 100)
        border = BorderFactory.createLineBorder(Color.BLACK, 2, true)
      }
      }

      contents += new Button("Hide cards") {
        preferredSize = new Dimension(200, 200)
        border = BorderFactory.createLineBorder(Color.BLACK, 2, true)
        reactions += { case ButtonClicked(_) =>
          seeFuturePopUp.visible = false
          context.setStrategy(new SeeTheFuture(i))
          context.executeStrategy(controller)
        }
      }
    }
  }

  def undo: Button = new Button("Undo") {
    preferredSize = new Dimension(100, 100)
    font = new Font(Font.Serif, 1, 15)
    reactions += {
      case ButtonClicked(_) =>
        controller.undo
    }
  }

  def redo: Button = new Button("Redo") {
    preferredSize = new Dimension(100, 100)
    font = new Font(Font.Serif, 1, 15)
    reactions += {
      case ButtonClicked(_) =>
        controller.redo()
    }
  }

}
