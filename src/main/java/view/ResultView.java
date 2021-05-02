package view;

import domain.Car;
import domain.CarPosition;
import domain.CarRacingResults;
import domain.Cars;

public class ResultView {
  private static final String CAR_NAME_AND_POSITION_RESULT_DELIMITER = " : ";
  private static final String CAR_POSITION_SYMBOL = "-";
  private static final String RESULT_DIVIDE_LINE = "\n";

  public static void printResults(CarRacingResults results) {
    System.out.println("실행 결과");
    for (Cars cars: results.getResults()) {
      printResult(cars);
    }
  }

  private static void printResult(Cars cars) {
    System.out.println(convertCarsToResultString(cars));
  }

  private static String convertCarsToResultString(Cars cars) {
    StringBuilder sb = new StringBuilder();
    for (Car car : cars.getCars()) {
      sb.append(car.getName().getName())
          .append(CAR_NAME_AND_POSITION_RESULT_DELIMITER)
          .append(createPositionSymbols(car.getPosition()))
          .append(RESULT_DIVIDE_LINE);
    }

    return sb.toString();
  }

  private static String createPositionSymbols(CarPosition position) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < position.getPosition(); i++) {
      sb.append(CAR_POSITION_SYMBOL);
    }

    return sb.toString();
  }
}
