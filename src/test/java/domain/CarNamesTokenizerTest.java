package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesTokenizerTest {
  private final Tokenizer tokenizer = new CarNamesTokenizer();

  @ParameterizedTest
  @CsvSource({
      "'123123', 1",
      "'123,123', 2",
      "'a,b,c,d,e,f,g,h,i,j,k', 11",
      "'abcd,efg', 2",
      "'asdf', 1"
  })
  void 입력문자열을_쉼표_구분자로_잘라_문자열_컬렉션으로_생성한다(String carNames, int expectedTokenSize) {
    List<CarName> tokens = tokenizer.tokenize(carNames);

    assertThat(tokens.size()).isEqualTo(expectedTokenSize);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "!,2,3,4",
      "a:b:c:d",
      "#,$,a,b"
  })
  void 입력문자열에서_자동차이름은_문자_혹은_숫자로만_이루어져_있지_않으면_예외가_발생한다(String carNames) {
    assertThrows(IllegalArgumentException.class, () -> {
      tokenizer.tokenize(carNames);
    });
  }

  @Test
  void 입력문자열에서_자동차이름을_구분짓는_구분자는_쉼표외에_다른것은_예외가발생한다() {
    String carNames = "a.b.c.d.e.f.g";
    assertThrows(IllegalArgumentException.class, () -> {
      tokenizer.tokenize(carNames);
    });
  }
}