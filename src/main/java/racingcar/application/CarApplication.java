package racingcar.application;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

public class CarApplication {

    private final DivideStrategy divideStrategy;

    public CarApplication(DivideStrategy divideStrategy) {
        this.divideStrategy = divideStrategy;
    }

    public Cars saveCars(String carNamesInput) {
        if (carNamesInput.isEmpty()) {
            throw new RacingCarException(RacingCarErrorCode.NAME_REQUIRED);
        }
        List<String> carNames = divideStrategy.divideByDelimiter(carNamesInput);
        List<Car> cars = carNames.stream()
                .map(Car::of)
                .toList();
        return Cars.of(cars);
    }
}
