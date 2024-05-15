package nz.ac.auckland.se281;

public class EasyDifficulty implements RobotDifficulty {

  private Strategy strategy;

  public EasyDifficulty(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play() {
    return strategy.getFingers();
  }
}
