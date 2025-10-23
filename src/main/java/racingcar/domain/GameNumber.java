package racingcar.domain;

import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

public class GameNumber {
    private final Integer value;

    private GameNumber(Integer value) {
        this.value = value;
    }

    public static GameNumber of(String gameNumber) {
        if (gameNumber.isEmpty()) {
            throw new RacingCarException(RacingCarErrorCode.GAME_NUMBER_REQUIRED);
        }
        try {
            return new GameNumber(Integer.parseInt(gameNumber));
        } catch (NumberFormatException e) {
            throw new RacingCarException(RacingCarErrorCode.INVALID_GAME_NUMBER);
        }
    }

    public Integer getValue() {
        return value;
    }
}
