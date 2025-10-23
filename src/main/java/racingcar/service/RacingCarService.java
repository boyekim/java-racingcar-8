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

    private List<String> divideByDelimiter(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(DELIMITER)).toList();
    }
}
