package racingcar.application;

import java.util.List;
import racingcar.application.config.AppConfig;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RaceService;
import racingcar.service.RacingCarService;

public class RacingCarApplication {

    private final Printer printer;
    private final Reader reader;
    private final RacingCarService racingCarService;

    public RacingCarApplication(AppConfig appConfig) {
        printer = appConfig.printer();
        reader = appConfig.reader();
        racingCarService = appConfig.racingCarService();
    }

    public void run() {
        printer.printStartingMessage();
        String carNamesInput = reader.read();
        Cars cars = racingCarService.saveCars(carNamesInput);
        printer.printCountMessage();
        Integer racingCounts = readRacingCounts();
        doRace(cars, racingCounts);
        List<Car> winners = racingCarService.findWinners(cars);
        printWinners(winners);
    }

    private Integer readRacingCounts() {
        return Integer.parseInt(reader.read());
    }

    private void doRace(Cars cars, Integer racingCounts) {
        RaceService raceService = new RaceService(cars);
        for (int i = 0; i < racingCounts; i++) {
            List<Car> carsAfterRace = raceService.doEachRace();
            printer.printEachResult(carsAfterRace);
        }
    }

    private void printWinners(List<Car> winners) {
        String winnerNames = buildWinnersName(winners);
        printer.printWinners(winnerNames);
    }

    private String buildWinnersName(List<Car> winners) {
        StringBuilder winnersName = new StringBuilder();
        for (int i = 0; i < winners.size() - 1; i++) {
            winnersName.append(winners.get(i).getName())
                    .append(", ");
        }
        winnersName.append(winners.getLast().getName());
        return winnersName.toString();
    }
}
