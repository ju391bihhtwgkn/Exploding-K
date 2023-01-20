package de.htwg.se.explodingKitten.aview

import de.htwg.se.explodingKitten.controller.ContextComponent.ContextInterface
import de.htwg.se.explodingKitten.controller.ControllerComponent.ControllerInterface
import de.htwg.se.explodingKitten.model.StrategyComponent._
import de.htwg.se.explodingKitten.util.Observer

import scala.io.StdIn.readLine

class Tui(controller: ControllerInterface, context: ContextInterface) extends Observer {

  controller.add(this)

  def processInputLine(): Unit = {
    while (controller.flag == true) {
      println("Your turn " + controller.gameState.players(controller.gameState.currentPlayer).name)
      println(controller.gameState.players(controller.gameState.currentPlayer).handCards.toString())
      val input = readLine()
      input match {
        case "t" => {
          if(controller.gameState.deck.head.cardName == "Exploding Kitten") {
            println("You have drawn a Exploding Kitten")
            println("Choose a place to put it into the deck!")
            context.setStrategy(new TakeExploding(readLine().toInt))
            context.executeStrategy(controller)

            context.setStrategy(new NextPlayer())
            context.executeStrategy(controller)
          } else {
            // Take a Card
            context.setStrategy(new TakeCard())
            context.executeStrategy(controller)
            // Next Player
            context.setStrategy(new NextPlayer())
            context.executeStrategy(controller)
          }
        }
        case "p" =>
          // Play a Card
          println("Which Card do you want to play ? Please enter the Number of the Card")
          val input = readLine().toInt
          val cardType = controller.gameState.players(controller.gameState.currentPlayer).handCards(input).actionCode

          cardType match {
            case 1 =>
              context.setStrategy(new DrawFromTheBottom(input))
              context.executeStrategy(controller)
            case 2 =>
              context.setStrategy(new SeeTheFuture(input))
              context.executeStrategy(controller)
            case 3 =>
              context.setStrategy(new Skip(input))
              context.executeStrategy(controller)
            case 4 =>
              context.setStrategy(new Attack(input))
            case 5 =>
              println("Choose a Player to Attack")
              context.setStrategy(new TargetedAttack(input, readLine().toInt))
              context.executeStrategy(controller)
            case 14 =>
              context.setStrategy(new Shuffle(input))
              context.executeStrategy(controller)
          }
        case "r" =>
          controller.redo()
        case "u" =>
          controller.undo()
      }
    }
  }
  override def update: Unit = controller.gameState
}
