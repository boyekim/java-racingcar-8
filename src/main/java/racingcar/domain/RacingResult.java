package racingcar.domain;

import java.util.List;

public class RacingResult {
    private final List<Cars> value;

    private RacingResult(List<Cars> value) {
        this.value = value;
    }

    public static RacingResult from(List<Cars> result) {
        return new RacingResult(result);
    }

    public List<String> findWinners() {
        Cars lastResult = value.getLast();
        List<Car> carsAtLastResult = lastResult.getValue();
        Integer winnerDistance = findWinnerDistance(carsAtLastResult);
        List<Car> winnerCars = getWinnerCars(carsAtLastResult, winnerDistance);
        return winnerCars.stream()
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

    private List<Car> getWinnerCars(List<Car> cars, Integer winnerDistance) {
        return cars.stream()
                .filter(car -> winnerDistance.equals(car.getDistance()))
                .toList();
    }

    public List<Cars> getValue() {
        return value;
    }
}
