package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsTest {
  private Tokenizer tokenizer = new CarNamesTokenizer();

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
  }
}