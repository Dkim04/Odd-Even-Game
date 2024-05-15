package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MediumDifficulty implements RobotDifficulty {

  private Strategy strategy;

  public MediumDifficulty(Strategy strategy, int roundNumber, ArrayList<Integer> playerHistory) {
    if (roundNumber <= 3) {
      this.strategy = strategy;
    } else {
      setStrategy(new TopStrategy(playerHistory));
    }
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play() {
    return strategy.getFingers();
  }
}
