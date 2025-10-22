package racingcar.application;

import java.util.List;
import racingcar.domain.Car;

public interface Printer {

    void print(String message);

    void printFormat(String format, String message);

    void printNewLine();

    void printStartingMessage();

    void printCountMessage();

    void printEachResult(List<Car> carsAfterRace);

    void printWinners(String winnerNames);
}
