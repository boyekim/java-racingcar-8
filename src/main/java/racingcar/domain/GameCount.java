package racingcar.domain;

import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

public class GameCount {
    private final Integer value;

    private GameCount(Integer value) {
        this.value = value;
    }

    public static GameCount from(String gameNumber) {
        validateGameNumberExist(gameNumber);
        Integer gameCount = validateGameCountInteger(gameNumber);
        validateGameCountPositive(gameCount);
        return new GameCount(gameCount);
    }

    private static void validateGameNumberExist(String gameNumber) {
        if (gameNumber.isEmpty()) {
            throw new RacingCarException(RacingCarErrorCode.GAME_NUMBER_REQUIRED);
        }
    }

    private static Integer validateGameCountInteger(String gameNumber) {
        try {
            return Integer.parseInt(gameNumber);
        } catch (NumberFormatException e) {
            throw new RacingCarException(RacingCarErrorCode.INVALID_GAME_NUMBER);
        }
    }

    private static void validateGameCountPositive(Integer gameCount) {
        if (gameCount < 0) {
            throw new RacingCarException(RacingCarErrorCode.NEGATIVE_GAME_COUNT_NOT_ALLOWED);
        }
    }

    public Integer getValue() {
        return value;
    }
}
