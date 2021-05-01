package view;

import java.util.Scanner;

public class InputView {
  private static final Scanner INPUT = new Scanner(System.in);

  public static String enterCarNames() {
    System.out.println(InputGuideComments.INPUT_CAR_NAMES_COMMENT);
    return INPUT.next();
  }
}
