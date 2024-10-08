package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This class is the TopStrategy.
 *
 * <p>This class implements the Strategy interface and is a strategy that the robot can use
 * depending on the difficulty level. This strategy is used when the robot wants to play a number of
 * fingers based on the player's history and the choice of the game.
 */
public class TopStrategy implements Strategy {

  private int amountofEvens = 0;
  private int amountofOdds = 0;
  private int fingers;

  /**
   * This constructor takes in the player's history and the choice of the player and decides to play
   * either an even or odd number of fingers from 0 to 5 based on the player's history and the
   * choice of the game. If the player played an equal amount of even and odd numbers, the robot
   * will play a random number of fingers from 0 and 5.
   */
  public TopStrategy(ArrayList<Integer> playerHistory, Choice choice) {
    for (int i : playerHistory) {
      if (Utils.isEven(i)) {
        amountofEvens++;
      } else if (Utils.isOdd(i)) {
        amountofOdds++;
      }
    }

    if (choice == Choice.EVEN) {

      if (amountofEvens > amountofOdds) {
        fingers = Utils.getRandomOddNumber();
      } else if (amountofEvens < amountofOdds) {
        fingers = Utils.getRandomEvenNumber();
      } else if (amountofEvens == amountofOdds) {
        fingers = Utils.getRandomNumberRange(0, 5);
      }

    } else if (choice == Choice.ODD) {

      if (amountofEvens > amountofOdds) {
        fingers = Utils.getRandomEvenNumber();
      } else if (amountofEvens < amountofOdds) {
        fingers = Utils.getRandomOddNumber();
      } else if (amountofEvens == amountofOdds) {
        fingers = Utils.getRandomNumberRange(0, 5);
      }
    }
  }

  /**
   * Gets the fingers of the robot.
   *
   * @return the fingers of the robot
   */
  @Override
  public int getFingers() {
    return fingers;
  }
}
