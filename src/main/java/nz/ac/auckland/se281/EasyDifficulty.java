package nz.ac.auckland.se281;

public class EasyDifficulty implements RobotDifficulty {

  private Strategy strategy;

  public EasyDifficulty() {
    this.strategy = new RandomStrategy();
  }

  @Override
  public Strategy getStrategy() {
    return strategy;
  }

  @Override
  public int play() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
