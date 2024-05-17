package nz.ac.auckland.se281;

/**
 * This class represents the EasyDifficulty.
 *
 * <p>This class implements the RobotDifficulty interface and is a difficulty level that the robot
 * can use. This difficulty level is used when the robot wants to play a random number of fingers.
 */
public class EasyDifficulty implements RobotDifficulty {

  private Strategy strategy;

  /**
   * This constructor creates a new EasyDifficulty object setting the strategy to a new
   * RandomStrategy.
   */
  public EasyDifficulty() {
    this.strategy = new RandomStrategy();
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
    return Utils.getRandomNumberRange(0, 5);
  }
}
