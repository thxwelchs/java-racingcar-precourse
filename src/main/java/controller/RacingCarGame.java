package controller;

import domain.Car;
import domain.CarName;
import domain.CarRacingResults;
import domain.Cars;
import domain.GameRound;
import domain.Tokenizer;
import view.InputView;
import view.ResultView;

public class RacingCarGame {
  private Cars cars;
  private GameRound round;
  private Tokenizer<CarName> tokenizer;
  private CarRacingResults results;

  public RacingCarGame(Tokenizer<CarName> tokenizer) {
    this.tokenizer = tokenizer;
    results = new CarRacingResults();
  }

  public void start() {
    initialize();

    while(round.isContinue()) {
      round.round();
      move();
      recordResult();
    }
  }

  private void move() {
    cars.moveAll();
  }

  private void recordResult() {
    results.addResult(cars);
  }

  public void doResult() {
    ResultView.printResults(results);
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
