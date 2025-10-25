package racingcar.domain;

import java.util.List;

public class RacingResult {
    List<Cars> value;

    private RacingResult(List<Cars> value) {
        this.value = value;
    }

    public static RacingResult of(List<Cars> result) {
        return new RacingResult(result);
    }

    public List<String> findWinners() {
        Cars lastResult = value.getLast();
        List<Car> allCar = lastResult.getValue();
        Integer winnerDistance = findWinnerDistance(allCar);
        return lastResult.getValue().stream()
                .filter(car -> winnerDistance.equals(car.getDistance()))
                .map(Car::getName)
                .toList();
    }

    private Integer findWinnerDistance(List<Car> cars) {
        int result = 0;
        for (Car car : cars) {
            result = Math.max(result, car.getDistance());
        }
        return result;
    }

    public List<Cars> getValue() {
        return value;
    }
}
