package domain;

import java.util.Collections;
import java.util.List;

public class WinnerCalculator {
  public static Winners calculate(Cars cars) {
    if(cars.isEmpty()) {
      return Winners.NONE;
    }

    return createWinners(cars);
  }

  private static Winners createWinners(Cars cars) {
    List<Car> racingCars = cars.clone().getCars();
    Winners winners = Winners.emptyWinners();

    Collections.sort(racingCars, (a, b) ->
        b.getPosition().getPosition() - a.getPosition().getPosition());

    for (Car racingCar : racingCars) {
      winners.compareAndAddWinner(cars.topPosition(), racingCar);
    }

    return winners;
  }
}
