package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

  @ParameterizedTest
  @CsvSource({
      "'name', 'name', true",
      "'name2', 'name2', true",
      "'name', 'name1', false",
      "'name', 'aman', false",
  })
  void 같은_문자열로_생성된_자동차이름은_같다(String carName, String compareCarName, boolean expected) {
    assertThat(CarName.from(carName).equals(CarName.from(compareCarName))).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "", " ", "   ", "   "
  })
  void 자동차이름을_빈_값으로_입력했을때_예외가발생한다(String carName) {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> CarName.from(carName));
    assertThat(exception.getMessage()).isEqualTo("자동차의 이름은 빈 값일 수 없습니다.");
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "abcdefg",
      "bcdfef",
      "namename"
  })
  void 자동차이름의_최대길이는_5이고_5보다큰_입력이주어졌을때_예외가발생한다(String carName) {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> CarName.from(carName));
    assertThat(exception.getMessage()).isEqualTo("자동차 이름의 길이는 최대 5까지 허용됩니다.");
  }
}
