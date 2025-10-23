package racingcar.exception;

public enum RacingCarErrorCode {
    NAME_LENGTH_LIMIT_EXCEEDED("이름은 %s자를 초과할 수 없습니다."),
    NAME_REQUIRED("이름은 비어있을 수 없습니다."),
    ;

    private final String message;

    RacingCarErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
