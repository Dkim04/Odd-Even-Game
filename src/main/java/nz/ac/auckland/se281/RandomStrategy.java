package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  /** This method returns a random number of fingers between 0 and 5 using the random method. */
  @Override
  public int getFingers() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
