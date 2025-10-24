package racingcar.application.numbergenerator;

import racingcar.application.ForwardStrategy;
import racingcar.application.NumberGenerator;

public class RacingCarForwardStrategy implements ForwardStrategy {

    private final NumberGenerator numberGenerator;

    public RacingCarForwardStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    private static final int MOVING_NUMBER = 4;

    @Override
    public boolean isMovingForward() {
        return numberGenerator.generateNumber() >= MOVING_NUMBER;
    }
}
