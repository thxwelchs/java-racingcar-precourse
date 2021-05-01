package domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
