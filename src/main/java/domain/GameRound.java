package domain;

public class GameRound {
  private static final int END_ROUND = 0;
  private int round;

  private GameRound(int round) {
    validate(round);
    this.round = round;
  }

  private void validate(int round) {
    if(round <= END_ROUND) {
      throw new IllegalArgumentException(String.format("자동차 전진 횟수는 %d이상 입력해야 합니다.", END_ROUND + 1));
    }
  }

  public void round() {
    round--;
  }

  public boolean isContinue() {
    return round > END_ROUND;
  }

  public static GameRound from(int round) {
    return new GameRound(round);
  }
}
