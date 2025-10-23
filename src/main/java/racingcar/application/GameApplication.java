package racingcar.application;

import java.util.ArrayList;
import racingcar.application.config.AppConfig;
import racingcar.domain.Cars;
import racingcar.domain.GameCount;
import racingcar.domain.RacingResult;
import racingcar.service.RacingCarService;
import racingcar.service.RacingService;

public class GameApplication {

    private final Printer printer;
    private final Reader reader;
    private final RacingCarService racingCarService;
    private final RacingService racingService;
    private final DivideStrategy divideStrategy;

    public GameApplication(AppConfig appConfig) {
        this.printer = appConfig.printer();
        this.reader = appConfig.reader();
        this.racingCarService = appConfig.racingCarService();
        this.racingService = appConfig.racingService();
        divideStrategy = appConfig.divideStrategy();
    }

    public void run() {
        printer.printStartingMessage();
        String carNamesInput = reader.read();
        Cars cars = racingCarService.saveCars(carNamesInput);

        printer.printCountMessage();
        String racingCounts = reader.read();

        RacingResult racingResult = racingService.race(
                cars,
                GameCount.of(racingCounts).getValue(),
                new ArrayList<>()
        );
        printer.printResult(racingResult);
    }
}
