package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingResultTest {

    @Test
    @DisplayName("결과를 모아두는 도메인 객체 정상 생성을 확인한다.")
    void makeRacingResult() {
        // given
        Car carA = Car.from("Boye");
        Car carB = Car.from("Sumin");
        Car carC = Car.from("Uchae");
        Cars firstRoundCars = Cars.from(List.of(carA, carB, carC));

        Car movedCarA = carA.move(true);
        Car movedCarB = carB.move(true);
        Cars secondRoundCars = Cars.from(List.of(movedCarA, movedCarB, carC));

        // when
        RacingResult racingResult = RacingResult.from(List.of(firstRoundCars, secondRoundCars));

        // then
        assertThat(racingResult.getValue())
                .extracting(Cars::getValue)
                .containsExactly(
                        List.of(carA, carB, carC),
                        List.of(movedCarA, movedCarB, carC)
                );
    }

    @Test
    @DisplayName("승자 판별 로직의 정상 동작을 확인한다.")
    void findWinner() {
        // given
        Car carA = Car.from("Boye");
        Car carB = Car.from("Sumin");
        Car carC = Car.from("Uchae");
        Cars firstRoundCars = Cars.from(List.of(carA, carB, carC));

        Car movedCarA = carA.move(true);
        Car movedCarB = carB.move(true);
        Cars secondRoundCars = Cars.from(List.of(movedCarA, movedCarB, carC));

        RacingResult racingResult = RacingResult.from(List.of(firstRoundCars, secondRoundCars));

        // when
        List<String> winners = racingResult.findWinners();

        // then
        assertThat(winners).containsExactly("Boye", "Sumin");
    }
}
