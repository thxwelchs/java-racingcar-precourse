package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
  public static final Winners NONE = emptyWinners();
  private List<CarName> winners;

  private Winners(List<CarName> winners) {
    this.winners = winners;
  }

  public void compareAndAddWinner(CarPosition topPosition, Car car) {
    if(car.getPosition().isGreaterThanOrEqualTo(topPosition)) {
      winners.add(car.getName());
    }
  }

  public List<CarName> getWinners() {
    return winners;
  }

  public static Winners emptyWinners() {
    return new Winners(new ArrayList<>());
  }
}
