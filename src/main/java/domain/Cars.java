package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
  private List<Car> cars;

  private Cars(CarsBuilder builder) {
    this.cars = builder.cars;
  }

  private static class CarsBuilder {
    private List<Car> cars;

    private CarsBuilder carNames(List<CarName> carNames) {
      this.cars = createCars(carNames);
      return this;
    }

    private CarsBuilder cars(List<Car> cars) {
      this.cars = cars;
      return this;
    }

    private List<Car> createCars(List<CarName> carNames) {
      List<Car> cars = new ArrayList<>();

      for (CarName carName : carNames) {
        cars.add(new Car(carName));
      }

      return cars;
    }

    private Cars build() {
      return new Cars(this);
    }
  }

  public void moveAll() {
    for (Car car : getCars()) {
      car.move(MoveConditionGenerator.generate());
    }
  }

  public Cars clone() {
    List<Car> clonedCars = new ArrayList<>();

    for (Car car : getCars()) {
      clonedCars.add(car.clone());
    }

    return new CarsBuilder()
        .cars(clonedCars)
        .build();
  }

  public List<Car> getCars() {
    return cars;
  }


  public static Cars of(String rawCarNames, Tokenizer<CarName> tokenizer) {
    List<CarName> carNames = tokenizer.tokenize(rawCarNames);

    return new CarsBuilder()
        .carNames(carNames)
        .build();
  }
}
