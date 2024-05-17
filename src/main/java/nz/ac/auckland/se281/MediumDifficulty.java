package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This class represents the MediumDifficulty.
 *
 * <p>This class implements the RobotDifficulty interface and is a difficulty level that the robot
 * can use. This difficulty level is used when the robot wants to play a number of fingers based on
 * the player's history and the choice of the game.
 */
public class MediumDifficulty implements RobotDifficulty {

  private Strategy strategy;

  /**
   * This constructor creates a new MediumDifficulty object setting the strategy to a new
   * RandomStrategy if the round number is less than or equal to 3, otherwise it sets the strategy
   * to a new TopStrategy.
   */
  public MediumDifficulty(Choice choice, int roundNumber, ArrayList<Integer> playerHistory) {
    if (roundNumber <= 3) {
      setStrategy(new RandomStrategy());
    } else {
      setStrategy(new TopStrategy(playerHistory, choice));
    }
  }

  /** This method sets the strategy that the robot will use. */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Gets the strategy that the robot will use.
   *
   * @return the strategy that the robot will use
   */
  @Override
  public Strategy getStrategy() {
    return strategy;
  }

  /**
   * Play method for the robot.
   *
   * @return the number of fingers that the robot will put out
   */
  @Override
  public int play() {
    return strategy.getFingers();
  }
}
