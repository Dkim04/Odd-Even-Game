package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class RobotDifficultyFactory {

  public static RobotDifficulty createRobotDifficulty(
      Difficulty difficulty,
      Choice choice,
      int roundNumber,
      ArrayList<Integer> playerHistory,
      boolean robotWin,
      Strategy lastStrategy) {
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
