import controller.RacingCarGame;
import domain.CarNamesTokenizer;

public class Application {
  public static void main(String[] args) {
    RacingCarGame game = new RacingCarGame(new CarNamesTokenizer());
    game.start();
    game.doResult();
  }
}
