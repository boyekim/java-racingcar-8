package racingcar.application;

import racingcar.application.config.AppConfig;
import racingcar.domain.Cars;
import racingcar.domain.GameCount;
import racingcar.domain.RacingResult;

public class GameApplication {

    private final Printer printer;
    private final Reader reader;
    private final CarApplication carApplication;
    private final RaceApplication raceApplication;

    public GameApplication(AppConfig appConfig) {
        printer = appConfig.printer();
        reader = appConfig.reader();
        carApplication = appConfig.racingCarService();
        raceApplication = appConfig.racingService();
    }

    public void run() {
        printer.printStartingMessage();
        String carNamesInput = reader.read();
        Cars cars = carApplication.saveCars(carNamesInput);

        printer.printCountMessage();
        String racingCounts = reader.read();

        RacingResult racingResult = raceApplication.race(cars, GameCount.of(racingCounts).getValue());
        printer.printResult(racingResult);
    }
}
