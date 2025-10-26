package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

class CarTest {

    @Test
    @DisplayName("이름이 다섯자 미만일 때에 정상적으로 자동차 객체가 생성된다.")
    void makeCar() {
        // given
        String name = "boye";

        // when
        Car car = Car.from(name);

        // then
        assertThat(car.getName()).isEqualTo("boye");
    }

    @Test
    @DisplayName("이름이 다섯자 일때에 정상적으로 자동차 객체가 생성된다.")
    void makeCarWithFiveWordName() {
        // given
        String name = "sumin";

        // when
        Car car = Car.from(name);

        // then
        assertThat(car.getName()).isEqualTo("sumin");
    }

    @Test
    @DisplayName("이름이 다섯자 초과일 때에 예외가 발생한다.")
    void makeExceptionExceedFiveWord() {
        // given
        String name = "boyekim";

        // when, then
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(String.format(RacingCarErrorCode.NAME_LENGTH_LIMIT_EXCEEDED.getMessage(), 5));
    }

    @Test
    @DisplayName("이름이 비어있을 때에 예외가 발생한다.")
    void makeExceptionWhenNameEmpty() {
        // given
        String name = "";

        // when, then
        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(RacingCarException.class)
                .hasMessage(RacingCarErrorCode.NAME_CAN_NOT_BE_EMPTY.getMessage());
    }

    @Test
    @DisplayName("움직일 때 정해진 거리가 정상적으로 늘어난다.")
    void moveForward() {
        // given
        int forwardLength = 1;
        Car car = Car.from("boye");

        // when
        Car movedCar = car.move(true);

        // then
        assertThat(movedCar.getDistance()).isEqualTo(forwardLength);
    }

    @Test
    @DisplayName("움직이지 않는 상황일 때 거리가 늘어나지 않는다.")
    void notMoveForward() {
        // given
        Car car = Car.from("boye");

        // when
        Car notMovedCar = car.move(false);

        // then
        assertThat(notMovedCar.getDistance()).isEqualTo(0);
    }
}
