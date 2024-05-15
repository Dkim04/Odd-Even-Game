package nz.ac.auckland.se281;

import java.util.ArrayList;

public class TopStrategy implements Strategy {

  public TopStrategy(ArrayList<Integer> playerHistory) {}

  @Override
  public int getFingers() {
    return 0;
  }
}
