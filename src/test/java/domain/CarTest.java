package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

  @ParameterizedTest
  @ValueSource(strings = {
      "name1",
      "name2",
      "name3",
      "name4"
  })
  void 자동차는_이름을가질수있고_초기위치는_0이다(String carName) {
    Car car = new Car(CarName.from(carName));

    assertThat(car.getName()).isEqualTo(CarName.from(carName));
    assertThat(car.getPosition().getPosition()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {
      1, 2, 3, 4, 5, 6, 7, 100, 999
  })
  void 자동차가_움직인횟수만큼_위치는_변경된다(int moveCount) {
    Car car = new Car(CarName.from("name"));
    assertThat(car.getPosition().getPosition()).isEqualTo(0);
    for(int i = 0; i < moveCount; i++) {
      car.move();
    }
    assertThat(car.getPosition().getPosition()).isEqualTo(moveCount);
  }
}
