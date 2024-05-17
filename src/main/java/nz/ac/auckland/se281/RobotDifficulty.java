package nz.ac.auckland.se281;

/**
 * Defines the methods for the robot difficulty levels.
 *
 * <p>This interface represents the different difficulties that the robot can have such as easy,
 * medium, or hard.
 */
public interface RobotDifficulty {

  /**
   * Gets the strategy that the robot will use.
   *
   * @return the strategy that the robot will use
   */
  public Strategy getStrategy();

  /**
   * Play method for the robot.
   *
   * @return the number of fingers that the robot will put out
   */
  public int play();
}
