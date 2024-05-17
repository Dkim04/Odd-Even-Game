package nz.ac.auckland.se281;

/**
 * This class represents the RandomStrategy.
 *
 * <p>This class implements the Strategy interface and is a strategy that the robot can use. This
 * strategy is used when the robot wants to play a random number of fingers.
 */
public class RandomStrategy implements Strategy {

  /**
   * Gets number of robot fingers.
   *
   * @return the number of fingers that the robot will put out
   */
  @Override
  public int getFingers() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
