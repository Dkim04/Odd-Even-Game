package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class HardDifficulty implements RobotDifficulty {

  private Strategy strategy;

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

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Strategy getStrategy() {
    return strategy;
  }

  public int play() {
    return strategy.getFingers();
  }
}
