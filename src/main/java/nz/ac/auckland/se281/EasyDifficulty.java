package nz.ac.auckland.se281;

public class EasyDifficulty implements RobotDifficulty {

  public EasyDifficulty() {}

  @Override
  public int play() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
