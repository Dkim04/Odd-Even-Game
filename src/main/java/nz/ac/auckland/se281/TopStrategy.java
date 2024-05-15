package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  private int amountofEvens = 0;
  private int amountofOdds = 0;
  private int fingers;

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

  @Override
  public int getFingers() {
    System.out.println("top");
    return fingers;
  }
}
