package domain;

import java.util.Random;

public class MoveConditionGenerator {
  private static final int MINIMUM_RANDOM_POSITION_VALUE = 0;
  private static final int MAXIMUM_RANDOM_POSITION_VALUE = 9;
  private static final Random RANDOM = new Random();

  public static int generate() {
    return RANDOM.nextInt(MAXIMUM_RANDOM_POSITION_VALUE - MINIMUM_RANDOM_POSITION_VALUE) + MINIMUM_RANDOM_POSITION_VALUE;
  }
}
