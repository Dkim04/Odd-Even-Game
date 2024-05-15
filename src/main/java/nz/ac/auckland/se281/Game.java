package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber = 0;
  private String playerName;
  private Difficulty gameDifficulty;
  private Choice gameChoice;
  private int robotFingers;
  private String sum;
  private ArrayList<Integer> playerHistory;
  private boolean robotWin = false;
  private Strategy lastStrategy;
  private boolean gameStarted = false;
  private int playersWins = 0;
  private int robotsWins = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
    gameDifficulty = difficulty;
    gameChoice = choice;
    playerHistory = new ArrayList<>();
    roundNumber = 0;
    gameStarted = true;
  }

  public void play() {

    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else if (gameStarted) {

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
          playerHistory.add(Integer.parseInt(input));
        } else {
          MessageCli.INVALID_INPUT.printMessage();
          input = Utils.scanner.nextLine();
        }
      }

      RobotDifficulty robotDifficulty =
          RobotDifficultyFactory.createRobotDifficulty(
              gameDifficulty, gameChoice, roundNumber, playerHistory, robotWin, lastStrategy);

      robotFingers = robotDifficulty.play();
      lastStrategy = robotDifficulty.getStrategy();

      // print output of robot
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(robotFingers));

      // obtain the sum of fingers as a string
      sum = Integer.toString(Integer.parseInt(input) + robotFingers);

      // check whether sum is even or odd and print correct output accordingly
      if (Utils.isEven(Integer.parseInt(sum))) {

        if (gameChoice == Choice.EVEN) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(sum, "EVEN", playerName);
          playersWins++;
          robotWin = false;
        } else if (gameChoice == Choice.ODD) {
          robotsWins++;
          robotWin = true;
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(sum, "EVEN", "HAL-9000");
        }

      } else if (Utils.isOdd(Integer.parseInt(sum))) {

        if (gameChoice == Choice.ODD) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(sum, "ODD", playerName);
          playersWins++;
          robotWin = false;
        } else if (gameChoice == Choice.EVEN) {
          robotsWins++;
          robotWin = true;
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(sum, "ODD", "HAL-9000");
        }
      }
    }
  }

  public void endGame() {

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(playersWins), Integer.toString(robotsWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(robotsWins), Integer.toString(playersWins));

    if (playersWins > robotsWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playersWins < robotsWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else if (playersWins == robotsWins) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    gameStarted = false;
  }

  public void showStats() {}
}
