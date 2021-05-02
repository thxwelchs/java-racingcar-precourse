package domain;

public class Car {
  private static final int MOVABLE_CONDITION = 4;
  private CarName name;
  private CarPosition position = CarPosition.create();

  public Car(CarName name) {
    this.name = name;
  }

  public void move() {
    position.increase();
  public void move(int condition) {
    if(isMovable(condition)) {
      position.increase();
    }
  }

  private boolean isMovable(int condition) {
    return condition >= MOVABLE_CONDITION;
  }

  public CarName getName() {
    return name;
  }

  public CarPosition getPosition() {
    return position;
  }
}
