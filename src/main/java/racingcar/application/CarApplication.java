package racingcar.application;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarApplication {

    private final DivideStrategy divideStrategy;

    public CarApplication(DivideStrategy divideStrategy) {
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
