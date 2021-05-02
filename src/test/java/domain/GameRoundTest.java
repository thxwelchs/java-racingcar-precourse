package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameRoundTest {

  @ParameterizedTest
  @ValueSource(ints = {
      -1, 0, -100, -9999
  })
  void 게임라운드는_자연수_범위를_넘어서는_입력이_주어지면_예외가_발생한다(int roundNumber) {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      GameRound.from(roundNumber);
    });

    assertThat(exception.getMessage()).isEqualTo("자동차 전진 횟수는 1이상 입력해야 합니다.");
  }

  @ParameterizedTest
  @ValueSource(ints = {
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10
  })
  void 게임라운드는_1회이상_일때_진행여부는_참을_반환한다(int roundNumber) {
    GameRound round = GameRound.from(roundNumber);
    assertThat(round.isContinue()).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10
  })
  void 게임라운드는_0회이하_일때_진행여부는_거짓을_반환한다(int roundNumber) {
    GameRound round = GameRound.from(roundNumber);
    for (int i = 0; i < roundNumber; i++) {
      round.round();
    }
    assertThat(round.isContinue()).isFalse();
  }

}