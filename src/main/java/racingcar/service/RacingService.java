package racingcar.service;

import java.util.List;
import racingcar.application.ForwardStrategy;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;

public class RacingService {

    private final ForwardStrategy forwardStrategy;

    public RacingService(ForwardStrategy forwardStrategy) {
        this.forwardStrategy = forwardStrategy;
    }

    public RacingResult race(Cars cars, Integer raceNumber, List<Cars> racingResult) {
        if (raceNumber == 0) {
            return RacingResult.of(racingResult);
        }
        Cars afterRace = doEachRace(cars);
        racingResult.add(afterRace);
        return race(afterRace, raceNumber - 1, racingResult);
    }

    private Cars doEachRace(Cars cars) {
        List<Car> allCars = cars.getValue();
        List<Car> racingResult = allCars.stream()
                .map(car -> car.move(forwardStrategy.isMovingForward()))
                .toList();
        return Cars.of(racingResult);
    }
}
