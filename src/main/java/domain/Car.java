package domain;

public class Car {
  private CarName name;
  private CarPosition position = CarPosition.create();

  public Car(CarName name) {
    this.name = name;
  }

  public void move() {
    position.increase();
  }

  public CarName getName() {
    return name;
  }

  public CarPosition getPosition() {
    return position;
  }
}
