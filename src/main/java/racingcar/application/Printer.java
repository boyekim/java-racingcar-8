package racingcar.application;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingResult;

public interface Printer {

    void print(String message);

    void printFormat(String format, String message);

    void printNewLine();

    void printStartingMessage();

    void printCountMessage();

//    void printEachResult(List<Car> carsAfterRace);

    void printWinners(String winnerNames);

    void printResult(RacingResult racingResult);
}
