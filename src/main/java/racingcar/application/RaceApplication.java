package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;

public class RaceApplication {

    private final ForwardStrategy forwardStrategy;

    public RaceApplication(ForwardStrategy forwardStrategy) {
        this.forwardStrategy = forwardStrategy;
    }

    public RacingResult race(Cars cars, Integer raceNumber) {
        List<Cars> carsToRace = new ArrayList<>();
        carsToRace.add(cars);
        List<Cars> racingResult = doRace(cars, raceNumber, carsToRace);
        return RacingResult.of(racingResult.subList(1, racingResult.size()));
    }

    public List<Cars> doRace(Cars cars, Integer raceCount, List<Cars> racingResult) {
        if (isRacingEnd(raceCount)) {
            return racingResult;
        }
        Cars afterEachRace = doEachRace(cars.getValue());
        racingResult.add(afterEachRace);
        return doRace(afterEachRace, raceCount - 1, racingResult);
    }

    private boolean isRacingEnd(Integer raceCount) {
        return raceCount == 0;
    }

    private Cars doEachRace(List<Car> cars) {
        List<Car> racingResult = cars.stream()
                .map(car -> car.move(forwardStrategy.isMovingForward()))
                .toList();
        return Cars.of(racingResult);
    }
}
