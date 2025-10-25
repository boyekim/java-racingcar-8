package racingcar.application.numbergenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.NumberGenerator;

class RacingCarForwardStrategyTest {

    @Test
    @DisplayName("숫자가 4 이상일 때에 true를 반환한다.")
    void moveForward() {
        // given
        AlwaysForwardGenerator alwaysForwardGenerator = new AlwaysForwardGenerator();
        RacingCarForwardStrategy racingCarForwardStrategy = new RacingCarForwardStrategy(alwaysForwardGenerator);

        // when
        boolean result = racingCarForwardStrategy.isMovingForward();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자가 4 미만일 때에 false를 반환한다.")
    void notMoveForward() {
        // given
        NeverForwardGenerator neverForwardGenerator = new NeverForwardGenerator();
        RacingCarForwardStrategy racingCarForwardStrategy = new RacingCarForwardStrategy(neverForwardGenerator);

        // when
        boolean result = racingCarForwardStrategy.isMovingForward();

        // then
        assertThat(result).isFalse();
    }

    private static class AlwaysForwardGenerator implements NumberGenerator {
        @Override
        public Integer generateNumber() {
            return 4;
        }
    }

    private static class NeverForwardGenerator implements NumberGenerator {
        @Override
        public Integer generateNumber() {
            return 3;
        }
    }
}
