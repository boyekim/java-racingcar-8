package racingcar.domain;

import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

public class Car {
    private final String name;
    private final Distance distance;

    private static final int NAME_LENGTH_LIMIT = 5;

    private Car(String name) {
        this.name = name;
        this.distance = new Distance();
    }

    public static Car of(String name) {
        validateNameLength(name);
        return new Car(name);
    }

    public void move(boolean canMove) {
        if (canMove) {
            distance.goForward();
        }
    }

    public String buildResult() {
        StringBuilder distanceResult = new StringBuilder(name);
        distanceResult.append(" : ");
        for (int i = 0; i < distance.getValue(); i++) {
            distanceResult.append("-");
        }
        return distanceResult.toString();
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new RacingCarException(RacingCarErrorCode.NAME_LENGTH_LIMIT_EXCEEDED, NAME_LENGTH_LIMIT);
        }
        if (name.isEmpty()) {
            throw new RacingCarException(RacingCarErrorCode.NAME_REQUIRED);
        }
    }

    public String getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }
}
