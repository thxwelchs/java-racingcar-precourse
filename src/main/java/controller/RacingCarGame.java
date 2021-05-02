package controller;

import domain.Cars;
import domain.GameRound;
import domain.Tokenizer;
import view.InputView;

public class RacingCarGame {
  private Cars cars;
  private GameRound round;

  public RacingCarGame(Tokenizer tokenizer) {
    initialCars(tokenizer);
  }

  public void start() {
    initialRounds();
    while(round.isContinue()) {
      round.round();
      cars.moveAll();
    }
  }

  public Cars getResults() {
    return cars;
  }

  private void initialCars(Tokenizer tokenizer) {
    String rawCarNames = InputView.enterCarNames();
    this.cars = Cars.of(rawCarNames, tokenizer);
  }

  private void initialRounds() {
    this.round = GameRound.from(InputView.enterRounds());
  }
}
