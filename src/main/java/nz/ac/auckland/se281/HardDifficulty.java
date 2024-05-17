package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class HardDifficulty implements RobotDifficulty {

  private Strategy strategy;

  /**
   * This constructor creates a new HardDifficulty object setting the strategy to a new
   * RandomStrategy if the round number is less than or equal to 3, otherwise it sets the strategy
   * to a new TopStrategy if the robot won the previous round and the last strategy was a
   * TopStrategy, or it sets the strategy to a new RandomStrategy if the robot won the previous
   * round and the last strategy was a RandomStrategy, or it sets the strategy to a new TopStrategy
   * if the robot lost the previous round and the last strategy was a RandomStrategy, or it sets the
   * strategy to a new RandomStrategy if the robot lost the previous round and the last strategy was
   * a TopStrategy.
   */
  public HardDifficulty(
      Choice choice,
      int roundNumber,
      ArrayList<Integer> playerHistory,
      boolean robotWin,
      Strategy lastStrategy) {

    if (roundNumber <= 3) {
      setStrategy(new RandomStrategy());

    } else if (robotWin) {

      if (lastStrategy.getClass() == TopStrategy.class) {
        setStrategy(new TopStrategy(playerHistory, choice));
      } else if (lastStrategy.getClass() == RandomStrategy.class) {
        setStrategy(new RandomStrategy());
      }

    } else if (!robotWin) {

      if (lastStrategy.getClass() == RandomStrategy.class) {
        setStrategy(new TopStrategy(playerHistory, choice));
      } else if (lastStrategy.getClass() == TopStrategy.class) setStrategy(new RandomStrategy());
    }
  }

  /** This method sets the strategy that the robot will use. */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /** This method returns the strategy that the robot will use. */
  public Strategy getStrategy() {
    return strategy;
  }

  /** This method returns the number of fingers that the robot will put out. */
  public int play() {
    return strategy.getFingers();
  }
}
