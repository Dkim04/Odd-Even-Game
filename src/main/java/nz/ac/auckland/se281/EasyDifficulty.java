package nz.ac.auckland.se281;

public class EasyDifficulty implements RobotDifficulty {

  private Strategy strategy;

  /**
   * This constructor creates a new EasyDifficulty object setting the strategy to a new
   * RandomStrategy
   */
  public EasyDifficulty() {
    this.strategy = new RandomStrategy();
  }

  /** This method returns the strategy that the robot will use. */
  @Override
  public Strategy getStrategy() {
    return strategy;
  }

  /** This method returns the number of fingers that the robot will put out. */
  @Override
  public int play() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
