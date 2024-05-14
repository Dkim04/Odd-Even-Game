package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber = 0;
  private String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
  }

  public void play() {

    boolean correctFingers = false;

    roundNumber++;

    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

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
  }

  public void endGame() {}

  public void showStats() {}
}
