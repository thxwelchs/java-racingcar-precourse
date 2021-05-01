package domain;

import java.util.Objects;

public class CarName {
  private static final String EMPTY_VALUE = "";
  private static final int EMPTY_LENGTH = 0;
  private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
  private String name;

  private CarName(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if(isEmpty(name)) {
      throw new IllegalArgumentException("자동차의 이름은 빈 값일 수 없습니다.");
    }

    if(isExceededLength(name)) {
      throw new IllegalArgumentException(String.format("자동차 이름의 길이는 최대 %d까지 허용됩니다.", MAXIMUM_CAR_NAME_LENGTH));
    }
  }

  private boolean isExceededLength(String name) {
    return name.length() > MAXIMUM_CAR_NAME_LENGTH;
  }

  private boolean isEmpty(String name) {
    return EMPTY_VALUE.equals(name) || name.length() == EMPTY_LENGTH;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarName carName = (CarName) o;
    return Objects.equals(name, carName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public static CarName from(String name) {
    return new CarName(name.trim());
  }
}
