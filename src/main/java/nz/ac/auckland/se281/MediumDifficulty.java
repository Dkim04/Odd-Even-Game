package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

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

  /** This method returns the strategy that the robot will use. */
  @Override
  public Strategy getStrategy() {
    return strategy;
  }

  /** This method returns the number of fingers that the robot will put out. */
  @Override
  public int play() {
    return strategy.getFingers();
  }
}
