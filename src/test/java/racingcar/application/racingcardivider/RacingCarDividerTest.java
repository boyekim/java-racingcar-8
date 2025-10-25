package racingcar.application.racingcardivider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

class RacingCarDividerTest {

    @Test
    @DisplayName("정상적으로 구분자로 이름을 나눈다.")
    void divideNames() {
        // given
        RacingCarDivider racingCarDivider = new RacingCarDivider();
        String input = "sumin,boye,uchae";

        // when
        List<String> names = racingCarDivider.divideByDelimiter(input);

        // then
        assertThat(names).containsExactly("sumin", "boye", "uchae");
    }

    @Test
    @DisplayName("이름이 중복될 때 예외가 발생한다.")
    void duplicatedNamesException() {
        // given
        RacingCarDivider racingCarDivider = new RacingCarDivider();
        String input = "boye,boye,sumin";

        // when, then
        assertThatThrownBy(() -> racingCarDivider.divideByDelimiter(input))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RacingCarErrorCode.DUPLICATED_NAME.getMessage());
    }
}
