package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarService {

    private static final String DELIMITER = ",";

    public Cars saveCars(String carNamesInput) {
        List<String> carNames = divideByDelimiter(carNamesInput);
        List<Car> cars = carNames.stream()
                .map(Car::of)
                .toList();
        return Cars.of(cars);
    }

    public List<Car> findWinners(Cars cars) {
        Integer winnerDistance = findWinnerDistance(cars);
        List<Car> allCars = cars.getValue();
        return allCars.stream()
                .filter(car -> winnerDistance.equals(car.getDistance().getValue()))
                .toList();
    }

    private Integer findWinnerDistance(Cars cars) {
        List<Car> allCars = cars.getValue();
        int maxDistance = 0;
        for (Car car : allCars) {
            maxDistance = Math.max(maxDistance, car.getDistance().getValue());
        }
        return maxDistance;
    }

    private List<String> divideByDelimiter(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(DELIMITER)).toList();
    }
}
