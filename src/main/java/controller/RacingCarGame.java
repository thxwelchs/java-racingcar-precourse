package controller;

import domain.Cars;
import domain.Tokenizer;
import view.InputView;

public class RacingCarGame {
  private Cars cars;

  public RacingCarGame(Tokenizer tokenizer) {
    this.cars = initialCars(tokenizer);
  }

  public void start() {
  }

  private Cars initialCars(Tokenizer tokenizer) {
    String rawCarNames = InputView.enterCarNames();
    return Cars.of(rawCarNames, tokenizer);
  }
}
