package domain;

import java.util.ArrayList;
import java.util.List;

public class CarNamesTokenizer implements Tokenizer<CarName> {
  private static final String CAR_NAMES_SPLIT_DELIMITER = ",";
  private static final String WORD_AND_DIGIT_REGEX = "[\\w\\d]";
  private static final String CAR_NAMES_REGEX = "(" + WORD_AND_DIGIT_REGEX + "+)" + "(" + CAR_NAMES_SPLIT_DELIMITER + "\\s*" + WORD_AND_DIGIT_REGEX + "+)*";

  private void validate(String carNames) {
    if(isNotMatchCarNames(carNames)) {
      throw new IllegalArgumentException(String.format("자동차의 이름은 문자와 숫자로만 이루어져야하고 여러 자동차의 이름일 경우엔 %s을 구분자로 이루어져야합니다.", CAR_NAMES_SPLIT_DELIMITER));
    }
  }

  private boolean isNotMatchCarNames(String carNames) {
    return !carNames.matches(CAR_NAMES_REGEX);
  }

  private List<String> createTokens(String[] splitCarNames) {
    List<String> tokens = new ArrayList<>();

    for (String token: splitCarNames) {
      tokens.add(token);
    }
    return tokens;
  }

  private List<CarName> convertToCarNames(List<String> carNames) {
    List<CarName> convertedCarNames = new ArrayList<>();

    for (String carName : carNames) {
      convertedCarNames.add(CarName.from(carName));
    }

    return convertedCarNames;
  }

  public List<CarName> tokenize(String carNames) {
    carNames = carNames.trim();
    validate(carNames);
    List<String> tokens = createTokens(carNames.split(CAR_NAMES_SPLIT_DELIMITER));
    return convertToCarNames(tokens);
  }
}
