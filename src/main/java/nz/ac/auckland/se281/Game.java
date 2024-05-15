package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber = 0;
  private String playerName;
  private Difficulty gameDifficulty;
  private Choice gameChoice;
  private int robotFingers;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
    gameDifficulty = difficulty;
    gameChoice = choice;
  }

  public void play() {

    boolean correctFingers = false;

    // increment the round number each time the method is called
    roundNumber++;

    // print start round message with round number and ask for input
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // keep a continuous loop until the correct amount of fingers is inputed
    while (!correctFingers) {
      for (int i = 0; i <= 5; i++) {
        if (input.equals(Integer.toString(i))) {
          correctFingers = true;
        }
      }

      if (correctFingers) {
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
      } else {
        MessageCli.INVALID_INPUT.printMessage();
        input = Utils.scanner.nextLine();
      }
    }

    // creating instances of each difficulty class
    EasyDifficulty easy = new EasyDifficulty(new RandomStrategy());

    // use swtich case method to call the right difficulty level
    switch (gameDifficulty) {
      case EASY:
        robotFingers = easy.play();
    }

    // print output of AI
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(robotFingers));
  }

  public void endGame() {}

  public void showStats() {}
}
