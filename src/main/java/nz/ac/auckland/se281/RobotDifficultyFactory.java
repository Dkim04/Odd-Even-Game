package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * This class is the RobotDifficultyFactory.
 *
 * <p>This class is a factory that creates a robot difficulty based on the difficulty level that the
 * user has chosen. It also takes in the choice of the player, the round number, the player's
 * history, whether the robot has won the previous round, and the last strategy that the robot used.
 */
public class RobotDifficultyFactory {

  /**
   * This method creates a robot difficulty based on the difficulty level that the user has chosen.
   * It also takes in the choice of the player, the round number, the player's history, whether the
   * robot has won the previous round, and the last strategy that the robot used. Since the
   * different difficulties have different constructors and parameters that are needed.
   */
  public static RobotDifficulty createRobotDifficulty(
      Difficulty difficulty,
      Choice choice,
      int roundNumber,
      ArrayList<Integer> playerHistory,
      boolean robotWin,
      Strategy lastStrategy) {

    // Return a new difficulty based on the difficulty level that the user has chosen and pass in
    // the correct parameters.
    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();

      case MEDIUM:
        return new MediumDifficulty(choice, roundNumber, playerHistory);

      case HARD:
        return new HardDifficulty(choice, roundNumber, playerHistory, robotWin, lastStrategy);
    }
    return null;
  }
}
