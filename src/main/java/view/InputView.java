package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
  private static final Scanner INPUT = new Scanner(System.in);

  public static void clearBuffer() {
    INPUT.nextLine();
  }

  public static String enterCarNames() {
    System.out.println(InputGuideComments.INPUT_CAR_NAMES_COMMENT);
    return INPUT.next();
  }

  public static int enterRounds() {
    System.out.println(InputGuideComments.INPUT_GAME_ROUND_COMMENT);

    int round = 0;

    try {
      round = INPUT.nextInt();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException("라운드는 숫자형태로 입력되어야 합니다.");
    }

    return round;
  }
}
