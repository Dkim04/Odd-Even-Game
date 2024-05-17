package nz.ac.auckland.se281;

/** This interface represents the different difficulties that the robot can have. */
public interface RobotDifficulty {

  /** This method returns the strategy that the robot will use. */
  public Strategy getStrategy();

  /** This method returns the number of fingers that the robot will put out. */
  public int play();
}
