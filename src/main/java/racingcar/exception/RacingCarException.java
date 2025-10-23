package racingcar.exception;

public class RacingCarException extends IllegalArgumentException {

    private final String errorCode;

    public RacingCarException(RacingCarErrorCode errorCode, Object... args) {
        super(String.format(errorCode.getMessage(), args));
        this.errorCode = errorCode.getMessage();
    }
}
