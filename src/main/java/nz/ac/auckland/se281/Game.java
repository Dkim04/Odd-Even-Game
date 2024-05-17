package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber = 0;
  private int robotFingers;
  private int playersWins = 0;
  private int robotsWins = 0;
  private String playerName;
  private String sum;
  private Choice gameChoice;
  private boolean robotWin = false;
  private boolean gameStarted = false;
  private Difficulty gameDifficulty;
  private Strategy lastStrategy;
  private ArrayList<Integer> playerHistory;

  /** This method is used to start a new game with the given parameters and initialize the game. */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
    gameDifficulty = difficulty;
    gameChoice = choice;
    playerHistory = new ArrayList<>();
    roundNumber = 0;
    gameStarted = true;
    playersWins = 0;
    robotsWins = 0;
    robotWin = false;
    lastStrategy = null;
  }

  /**
   * This method is used to play a round of the game, while printing the player's input and the
   * robot's input and showing the winner.
   */
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

  /**
   * This method is used to end the game and print the rounds each player won and the winner of the
   * game or a tie if it was a tie.
   */
  public void endGame() {

    // if the game has not started, print a message saying the game has not started
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else if (gameStarted) {
      // print how many times each player has won
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, Integer.toString(playersWins), Integer.toString(robotsWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000", Integer.toString(robotsWins), Integer.toString(playersWins));

      // print the winner of the game or a tie if it was a tie
      if (playersWins > robotsWins) {
        MessageCli.PRINT_END_GAME.printMessage(playerName);
      } else if (playersWins < robotsWins) {
        MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
      } else if (playersWins == robotsWins) {
        MessageCli.PRINT_END_GAME_TIE.printMessage();
      }

      // reset the gameStarted variable to false
      gameStarted = false;
    }
  }

  /** This method is used to show the statistics of the game any time during the game. */
  public void showStats() {
    // if the game has not started, print a message saying the game has not started
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else if (gameStarted) {
      // print how many times each player has won
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, Integer.toString(playersWins), Integer.toString(robotsWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000", Integer.toString(robotsWins), Integer.toString(playersWins));
    }
  }
}
