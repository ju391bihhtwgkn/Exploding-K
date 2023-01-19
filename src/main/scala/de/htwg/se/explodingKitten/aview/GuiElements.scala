package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.ControllerInterface
import de.htwg.se.explodingKitten.controller.controllerBaseImplementation.{Controller, GameContext}
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.Card
import de.htwg.se.explodingKitten.model.GamestateBaseImplementation.strategy.{Attack, DrawFromTheBottom, NextPlayer, PlayCard, SeeTheFuture, Shuffle, Skip, TakeCard, TakeExploding, TargetedAttack}

import java.awt.{Color, Point}
import javax.swing.{BorderFactory, Box, ImageIcon}
import scala.swing.Alignment.{Center, Top}
import scala.swing.event.{ButtonClicked, MouseClicked}
import scala.swing.{BoxPanel, Button, Dimension, Font, Frame, GridBagPanel, GridPanel, Insets, InternalFrame, Label, Menu, Orientation, PopupMenu, ScrollPane, Slider, TextArea, TextField}

case class GuiElements(controller: ControllerInterface) {

  var context = new GameContext(null)
  var popup = new PopupMenu
  var explodingPopup = new PopupMenu
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
    val hasDefuse = controller.gameState.players(controller.gameState.currentPlayer).handCards.indexWhere(Card => Card.cardName == "Defuse")
    println(hasDefuse)
    reactions += { case ButtonClicked(_) =>
      if (controller.gameState.deck.head.cardName == "Exploding Kitten" && hasDefuse != -1) {
        explodingPopup = explodingPopUp()
        explodingPopup.visible = true
      } else if (controller.gameState.deck.head.cardName == "Exploding Kitten" && hasDefuse == -1) {
        context.setStrategy(new TakeCard())
        context.executeStrategy(controller)
      } else {
        context.setStrategy(new TakeCard())
        context.executeStrategy(controller)

        context.setStrategy(new NextPlayer())
        context.executeStrategy(controller)
      }

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
        case "Shuffle" => new ImageIcon("src/resscources/Shuffle.PNG")
      }
      preferredSize = new Dimension(250, 380)
    }

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
      println("players")
      println(controller.gameState.currentPlayer)
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
              case "Shuffle" => new ImageIcon("src/ressources/Shuffle.PNG")
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
                case 5 =>
                  popup = popupMenu(i)
                  popup.visible = true
                case 15 =>
                  context.setStrategy(new Shuffle(i))
                  context.executeStrategy(controller)
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
    preferredSize = new Dimension(400, 400)
    val otherPlayers = controller.gameState.players.filterNot(x => {
      x.name == controller.gameState.players(controller.gameState.currentPlayer).name
    })
    if(controller.gameState.players.length > 2) {
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
    } else {
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
      }
    }
  }

  val label1 = new Label("Where do you want to put the Exploding Kitten?") {
    preferredSize = new Dimension(200, 200)
  }

  val slider = new Slider {
    min = 1
    max = controller.gameState.deck.length - 1
    minorTickSpacing = 1
    majorTickSpacing = 5
    paintTicks = true
  }

  val button = new Button("Put card into deck") {
    preferredSize = new Dimension(200, 200)
    reactions += {
      case ButtonClicked(_) =>
        println(slider.value)
        context.setStrategy(new TakeExploding(slider.value))
        context.executeStrategy(controller)
        context.setStrategy(new NextPlayer())
        context.executeStrategy(controller)
        explodingPopup.visible = false
    }
  }

  def explodingPopUp(): PopupMenu = new PopupMenu() {
    preferredSize = new Dimension(400, 400)
    contents += new BoxPanel(Orientation.Vertical) {
      contents += label1
      contents += slider
      contents += button
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
