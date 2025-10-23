package racingcar.application;

import racingcar.domain.RacingResult;

public interface Printer {

    void print(String message);

    void printFormat(String format, String message);

    void printNewLine();

    void printStartingMessage();

    void printCountMessage();

    void printResult(RacingResult racingResult);
}
