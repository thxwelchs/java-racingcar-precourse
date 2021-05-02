package domain;

public class CarPosition {
  private static final int INITIAL_CAR_POSITION = 0;
  private int position;

  private CarPosition(int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public void increase() {
    position++;
  }

  public CarPosition clone() {
    return new CarPosition(this.position);
  }

  public static CarPosition create() {
    return new CarPosition(INITIAL_CAR_POSITION);
  }
}
