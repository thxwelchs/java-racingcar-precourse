import controller.RacingCarGame;
import domain.CarNamesTokenizer;
import java.util.List;
import view.InputView;

public class Application {
  public static void main(String[] args) {
    RacingCarGame game = new RacingCarGame(new CarNamesTokenizer());
    game.start();
  }
}
