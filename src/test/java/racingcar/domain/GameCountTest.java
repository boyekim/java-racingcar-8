package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

class GameCountTest {

    @Test
    @DisplayName("게임 횟수 숫자가 양의 정수로 입력되었을 때에 정상동작을 확인한다.")
    void makeGameCount() {
        // given
        String gameNumber = "3";

        // when
        GameCount gameCount = GameCount.from(gameNumber);

        // then
        assertThat(gameCount.getValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 횟수가 음의 정수로 입력되었을 때에 예외를 확인한다.")
    void negativeGameCountException() {
        // given
        String gameNumber = "-3";

        // when, then
        assertThatThrownBy(() -> GameCount.from(gameNumber))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RacingCarErrorCode.NEGATIVE_GAME_COUNT_NOT_ALLOWED.getMessage());
    }

    @Test
    @DisplayName("게임 횟수가 소수가 입력되었을 때에 예외를 확인한다.")
    void notIntegerGameCountException() {
        // given
        String gameNumber = "1.1";

        // when, then
        assertThatThrownBy(() -> GameCount.from(gameNumber))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RacingCarErrorCode.INVALID_GAME_NUMBER.getMessage());
    }

    @Test
    @DisplayName("게임 횟수가 숫자가 아닌 형태일 때에 예외를 확인한다.")
    void notNumberGameCountException() {
        // given
        String gameNumber = "a";

        // when, then
        assertThatThrownBy(() -> GameCount.from(gameNumber))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RacingCarErrorCode.INVALID_GAME_NUMBER.getMessage());
    }

    @Test
    @DisplayName("빈 입력을 게임 횟수로 입력할 때에 예외를 확인한다.")
    void emptyGameCountException() {
        // given
        String gameNumber = "";

        // when, then
        assertThatThrownBy(() -> GameCount.from(gameNumber))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RacingCarErrorCode.GAME_NUMBER_REQUIRED.getMessage());
    }
}
