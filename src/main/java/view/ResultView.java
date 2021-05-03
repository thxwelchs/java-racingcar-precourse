package view;

import domain.Car;
import domain.CarName;
import domain.CarPosition;
import domain.CarRacingResults;
import domain.Cars;
import domain.Winners;
import java.util.ArrayList;
import java.util.List;

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

  public static void printWinners(Winners winners) {
    System.out.println(createSequentialWinnerNames(winners) + "가 최종 우승했습니다.");
  }

  private static String createSequentialWinnerNames(Winners winners) {
    List<String> winnerNames = new ArrayList<>();
    for (CarName winner : winners.getWinners()) {
      winnerNames.add(winner.getName());
    }
    return String.join(", ", winnerNames);
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

  public static void printError(RuntimeException e) {
    System.out.println(e.getMessage() + " (다시 입력해주세요.)");
  }

  public static void printError(String message) {
    System.out.println(message);
  }
}
