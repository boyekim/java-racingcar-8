package racingcar.application.numbergenerator;

import racingcar.application.ForwardStrategy;
import racingcar.util.RandomNumberGenerator;

public class RacingCarForwardStrategy implements ForwardStrategy {

    private static final int MOVING_NUMBER = 4;

    @Override
    public boolean isMovingForward() {
        return RandomNumberGenerator.generateRandomNumber() >= MOVING_NUMBER;
    }
}
