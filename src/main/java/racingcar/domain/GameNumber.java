package racingcar.domain;

import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

public class GameNumber {
    private Integer value;

    private GameNumber(Integer value) {
        this.value = value;
    }

    public static GameNumber of(String gameNumber) {
        try {
            return new GameNumber(Integer.parseInt(gameNumber));
        } catch (NumberFormatException e) {
            throw new RacingCarException(RacingCarErrorCode.INVALID_GAME_NUMBER);
        }
    }
}
