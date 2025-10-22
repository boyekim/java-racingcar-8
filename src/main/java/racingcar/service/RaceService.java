package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;

public class RaceService {

    private final Cars cars;

    private static final Integer MOVE_MINIMUM = 4;

    public RaceService(Cars cars) {
        this.cars = cars;
    }

    public List<Car> doEachRace() {
        List<Car> allCars = cars.getValue();
        for (Car car : allCars) {
            car.move(isCanMove());
        }
        return allCars;
    }

    private boolean isCanMove() {
        Integer randomNumber = RandomNumberGenerator.generateRandomNumber();
        return randomNumber >= MOVE_MINIMUM;
    }
}
