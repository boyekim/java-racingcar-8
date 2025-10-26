package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차 목록이 정상 저장됨을 확인한다.")
    void saveCars() {
        // given
        Car carA = Car.from("Boye");
        Car carB = Car.from("Sumin");
        Car carC = Car.from("Uchae");

        // when
        Cars cars = Cars.from(List.of(carA, carB, carC));

        // then
        assertThat(cars.getValue())
                .extracting(Car::getName, Car::getDistance)
                .containsExactly(
                        tuple("Boye", 0),
                        tuple("Sumin", 0),
                        tuple("Uchae", 0)
                );
    }
}
