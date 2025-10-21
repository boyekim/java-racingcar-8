package racingcar.application.config;

import racingcar.application.Printer;
import racingcar.application.printer.RacingCarPrinter;

public class AppConfig {

    public Printer printer() {
        return new RacingCarPrinter();
    }
}
