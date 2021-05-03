import controller.RacingCarGame;
import domain.CarNamesTokenizer;
import java.util.InputMismatchException;
import view.InputView;
import view.ResultView;

public class Application {
  public static void main(String[] args) {
    run();
  }

  private static void run() {
    try {
      RacingCarGame game = new RacingCarGame(new CarNamesTokenizer());
      game.start();
      game.doResult();
    } catch (IllegalArgumentException | InputMismatchException e) {
      retry(e);
    } catch (RuntimeException e) {
      ResultView.printError("알 수 없는 에러가 발생했습니다. 프로그램을 다시 실행해주세요.");
    }
  }

  private static void retry(RuntimeException e) {
    ResultView.printError(e);
    InputView.clearBuffer();
    run();
  }
}
