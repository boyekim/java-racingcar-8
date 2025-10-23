package racingcar.application;

import java.util.ArrayList;
import racingcar.application.config.AppConfig;
import racingcar.domain.Cars;
import racingcar.domain.GameCount;
import racingcar.domain.RacingResult;
import racingcar.service.RacingCarService;

public class GameApplication {

    private final Printer printer;
    private final Reader reader;
    private final ForwardStrategy forwardStrategy;
    private final RacingCarService racingCarService;

    public GameApplication(AppConfig appConfig) {
        this.printer = appConfig.printer();
        this.reader = appConfig.reader();
        this.forwardStrategy = appConfig.forwardStrategy();
        this.racingCarService = appConfig.racingCarService();
    }

    public void run() {
        printer.printStartingMessage();
        String carNamesInput = reader.read();
        Cars cars = racingCarService.saveCars(carNamesInput);

        printer.printCountMessage();
        String racingCounts = reader.read();

        RacingApplication racingApplication = new RacingApplication(forwardStrategy);
        RacingResult afterRaceCars = racingApplication.race(
                cars,
                GameCount.of(racingCounts).getValue(),
                new ArrayList<>()
        );
        printer.printResult(afterRaceCars);
    }
}
