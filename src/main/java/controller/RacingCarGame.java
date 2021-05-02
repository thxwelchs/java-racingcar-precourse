package controller;

import domain.Cars;
import domain.GameRound;
import domain.MoveConditionGenerator;
import domain.Tokenizer;
import view.InputView;

public class RacingCarGame {
  private Cars cars;
  private GameRound round;

  private Tokenizer tokenizer;

  public RacingCarGame(Tokenizer tokenizer) {
    this.tokenizer = tokenizer;
  }

  public void start() {
    initialize();

    while(round.isContinue()) {
      round.round();
      cars.moveAll();
    }
  }

  public Cars getResults() {
    return cars;
  }

  private void initialize() {
    initialCars();
    initialRounds();
  }

  private void initialCars() {
    String rawCarNames = InputView.enterCarNames();
    this.cars = Cars.of(rawCarNames, tokenizer);
  }

  private void initialRounds() {
    this.round = GameRound.from(InputView.enterRounds());
  }
}
