package racingcar.exception;

public enum RacingCarErrorCode {
    NAME_LENGTH_LIMIT_EXCEEDED("이름은 %s자를 초과할 수 없습니다."),
    NAME_CAN_NOT_BE_EMPTY("이름은 비어있을 수 없습니다."),
    INVALID_GAME_NUMBER("게임 횟수는 숫자가 입력되어야 합니다."),
    GAME_NUMBER_REQUIRED("게임 횟수가 입력되어야 합니다."),
    NAME_REQUIRED("최소 한명의 이름이 입력되어야 합니다."),
    DUPLICATED_NAME("이미 존재하는 이름입니다."),
    ;

    private final String message;

    RacingCarErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
