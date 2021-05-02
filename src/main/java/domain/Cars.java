package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
  private List<Car> cars;

  private Cars(List<CarName> carNames) {
    this.cars = createCars(carNames);
  }

  private List<Car> createCars(List<CarName> carNames) {
    List<Car> cars = new ArrayList<>();

    for (CarName carName : carNames) {
      cars.add(new Car(carName));
    }

    return cars;
  public void moveAll() {
    for (Car car : getCars()) {
      car.move();
    }
  }

  public List<Car> getCars() {
    return cars;
  }

  public static Cars of(String rawCarNames, Tokenizer tokenizer) {
    List<CarName> carNames = tokenizer.tokenize(rawCarNames);

    return new Cars(carNames);
  }
}
