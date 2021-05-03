package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WinnerCalculatorTest {
  Tokenizer<CarName> tokenizer = new CarNamesTokenizer();
  Cars cars = Cars.of("a,b,c,d,e", tokenizer);

  @BeforeAll
  void setUp() {
    moveAndSortDesc();
  }

  private void moveAndSortDesc() {
    for (int i = 0; i < 100; i++) {
      cars.moveAll();
    }
    Collections.sort(cars.getCars(), (a, b) -> b.getPosition().getPosition() - a.getPosition().getPosition());
  }

  @RepeatedTest(10)
  void 포지션값이_가장_높은_자동차를_우승자로_뽑는다() {
    Winners winners = WinnerCalculator.calculate(cars);
    assertThat(winners.getWinners().get(0)).isEqualTo(cars.getCars().get(0).getName());
  }

  @RepeatedTest(10)
  void 포지션값이_가장_높은_자동차가_우승자로_뽑고_가장_높은_점수를_가진_우승자는_1명이상일수있다() {
    Winners winners = WinnerCalculator.calculate(cars);
    assertThat(winners.getWinners().size()).isGreaterThanOrEqualTo(1);
    for (int i = 0; i < winners.getWinners().size(); i++) {
      assertThat(cars.getCars().get(i).getPosition().getPosition()).isEqualTo(cars.topPosition().getPosition());
      assertThat(winners.getWinners().get(i)).isEqualTo(cars.getCars().get(i).getName());
    }
  }
}