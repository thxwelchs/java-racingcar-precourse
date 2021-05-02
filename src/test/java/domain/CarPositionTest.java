package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarPositionTest {

  @ParameterizedTest
  @ValueSource(ints = {
      1, 2, 3, 4, 5, 100
  })
  void 자동차의위치는_초기에_0이고_위치값은_증가시킨만큼_변경된다(int increaseCount) {
    CarPosition carPosition = CarPosition.create();
    assertThat(carPosition.getPosition()).isEqualTo(0);
    for(int i = 0; i < increaseCount; i++) {
      carPosition.increase();
    }
    assertThat(carPosition.getPosition()).isEqualTo(increaseCount);
  }

  @Test
  void 복제된_자동차위치와_기존자동차위치는_다르다() {
    CarPosition carPosition = CarPosition.create();
    assertThat(carPosition).isNotEqualTo(carPosition.clone());
  }
}