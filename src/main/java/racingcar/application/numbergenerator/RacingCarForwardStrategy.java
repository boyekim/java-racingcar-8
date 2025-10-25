package racingcar.application.numbergenerator;

import racingcar.application.ForwardStrategy;
import racingcar.application.NumberGenerator;

public class RacingCarForwardStrategy implements ForwardStrategy {

    private final NumberGenerator numberGenerator;

    private static final int MOVING_NUMBER = 4;

    public RacingCarForwardStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovingForward() {
        return numberGenerator.generateNumber() >= MOVING_NUMBER;
    }
}
