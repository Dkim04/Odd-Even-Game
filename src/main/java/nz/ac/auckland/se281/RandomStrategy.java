package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int getFingers() {
    System.out.println("random");
    return Utils.getRandomNumberRange(0, 5);
  }
}
