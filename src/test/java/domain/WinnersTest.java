package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
class WinnersTest {

  private static final int TOP_POSITION = 100;
  private CarPosition topPosition = CarPosition.create();

  @BeforeAll
  void setUp() {
    setTopPosition();
  }

  private void setTopPosition() {
    for (int i = 0; i < TOP_POSITION; i++) {
      topPosition.increase();
    }
  }

  @Test
  void emptyWinners에는_빈_컬렉션이들어있다() {
    Winners winners = Winners.emptyWinners();
    assertThat(winners.getWinners().isEmpty()).isTrue();
    assertThat(winners.getWinners().size()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {
      1, 10, 50, 99
  })
  void 가장높은포지션_값과_비교하여_비교할_자동차의_포지션값이_그_미만이라면_우승자를_추가하지않는다(int moveCount) {
    Car car = new Car(CarName.from("name"));
    for (int i = 0; i < moveCount; i++) {
      car.move(4);
    }
    Winners winners = Winners.emptyWinners();
    winners.compareAndAddWinner(topPosition, car);
    assertThat(winners.getWinners().size()).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(ints = {
      100, 101, 200, 1000
  })
  void 가장높은포지션_값과_비교하여_비교할_자동차의_포지션값이_그_이상이라면_우승자를_추가한다(int moveCount) {
    Car car = new Car(CarName.from("name"));
    for (int i = 0; i < moveCount; i++) {
      car.move(4);
    }
    Winners winners = Winners.emptyWinners();
    winners.compareAndAddWinner(topPosition, car);
    assertThat(winners.getWinners().size()).isGreaterThanOrEqualTo(1);
    assertThat(winners.getWinners().get(0)).isEqualTo(car.getName());
  }
}