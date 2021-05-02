package domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingResults {
  private List<Cars> results = new ArrayList<>();

  public void addResult(Cars cars) {
    results.add(cars.clone());
  }

  public List<Cars> getResults() {
    return results;
  }
}
