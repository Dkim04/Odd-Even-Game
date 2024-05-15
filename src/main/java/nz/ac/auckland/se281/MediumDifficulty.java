package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class MediumDifficulty implements RobotDifficulty {

  private Strategy strategy;

  public MediumDifficulty(Choice choice, int roundNumber, ArrayList<Integer> playerHistory) {
    if (roundNumber <= 3) {
      this.strategy = new RandomStrategy();
    } else {
      setStrategy(new TopStrategy(playerHistory, choice));
    }
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public int play() {
    return strategy.getFingers();
  }
}
