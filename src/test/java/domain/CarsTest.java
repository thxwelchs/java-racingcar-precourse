package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {
  private Tokenizer<CarName> tokenizer = new CarNamesTokenizer();

  @Test
  void 입력문자열과_tokenizer를_주입받아_Cars일급컬렉션을생성한다() {
    Cars cars = Cars.of("a,b,c,d,e", tokenizer);

    assertThat(cars.getCars().size()).isEqualTo(5);
    assertThat(cars.getCars().get(0).getName()).isEqualTo(CarName.from("a"));
    assertThat(cars.getCars().get(1).getName()).isEqualTo(CarName.from("b"));
    assertThat(cars.getCars().get(2).getName()).isEqualTo(CarName.from("c"));
    assertThat(cars.getCars().get(3).getName()).isEqualTo(CarName.from("d"));
    assertThat(cars.getCars().get(4).getName()).isEqualTo(CarName.from("e"));
  }

  @Test
  void 복제된Cars는_서로_다르며_가지고있는_Car들도_모두_복제되어_다르다() {
    Cars cars = Cars.of("a,b,c", tokenizer);
    Cars cars2 = cars.clone();

    assertThat(cars).isNotEqualTo(cars2);
    assertThat(cars.getCars().size()).isEqualTo(cars2.getCars().size());
    assertThat(cars.getCars().get(0)).isNotEqualTo(cars2.getCars().get(0));
    assertThat(cars.getCars().get(1)).isNotEqualTo(cars2.getCars().get(1));
    assertThat(cars.getCars().get(2)).isNotEqualTo(cars2.getCars().get(2));
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "a,b,b",
      "a,a,b",
      "name1,name2,name1,name2",
      "name1, name1, name1 "
  })
  void 중복된_자동차이름을_입력하면_예외가_발생한다(String carNames) {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      Cars.of(carNames, tokenizer);
    });

    assertThat(exception.getMessage()).isEqualTo("자동차 이름은 중복 될 수 없습니다.");
  }
}