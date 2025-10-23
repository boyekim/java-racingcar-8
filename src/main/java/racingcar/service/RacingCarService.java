package racingcar.service;

import java.util.List;
import racingcar.application.DivideStrategy;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingCarService {

    private final DivideStrategy divideStrategy;

    public RacingCarService(DivideStrategy divideStrategy) {
        this.divideStrategy = divideStrategy;
    }

    public Cars saveCars(String carNamesInput) {
        List<String> carNames = divideStrategy.divideByDelimiter(carNamesInput);
        List<Car> cars = carNames.stream()
                .map(Car::of)
                .toList();
        return Cars.of(cars);
    }
}
