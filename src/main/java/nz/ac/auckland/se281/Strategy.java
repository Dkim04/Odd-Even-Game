package nz.ac.auckland.se281;

/**
 * This interface represents the different strategies that the robot can use depending on the
 * difficulty level.
 *
 * <p>getFingers() returns the number of fingers that the robot will put out.
 */
public interface Strategy {
  public int getFingers();
}
