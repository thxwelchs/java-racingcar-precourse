package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class MoveConditionGeneratorTest {

  @RepeatedTest(100)
  void 자동차가움직이는조건숫자는_항상_0이상_9이하로_생성된다() {
    int moveCondition = MoveConditionGenerator.generate();
    assertThat(moveCondition).isGreaterThanOrEqualTo(0);
    assertThat(moveCondition).isLessThanOrEqualTo(9);
  }
}