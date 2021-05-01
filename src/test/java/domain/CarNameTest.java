package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarNameTest {

  @ParameterizedTest
  @CsvSource({
      "'name', 'name', true",
      "'name2', 'name2', true",
      "'thisiscarname', 'thatiscarname', false",
      "'iamcar', 'iamnotcar', false",
  })
  void 같은_문자열로_생성된_자동차이름은_같다(String carName, String compareCarName, boolean expected) {
    assertThat(CarName.from(carName).equals(CarName.from(compareCarName))).isEqualTo(expected);
  }
}
