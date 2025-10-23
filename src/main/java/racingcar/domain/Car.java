package racingcar.domain;

import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

public class Car {
    private final String name;
    private final Integer distance;

    private static final int NAME_LENGTH_LIMIT = 5;

    private Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    private Car(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car of(String name) {
        validateNameLength(name);
        return new Car(name);
    }

    public Car move(boolean canMove) {
        if (canMove) {
            return new Car(name, distance + 1);
        }
        return new Car(name, distance);
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new RacingCarException(RacingCarErrorCode.NAME_LENGTH_LIMIT_EXCEEDED, NAME_LENGTH_LIMIT);
        }
        if (name.isEmpty()) {
            throw new RacingCarException(RacingCarErrorCode.NAME_CAN_NOT_BE_EMPTY);
        }
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
