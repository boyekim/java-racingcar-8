package racingcar.application.config;

import racingcar.application.Printer;
import racingcar.application.Reader;
import racingcar.application.printer.RacingCarPrinter;
import racingcar.application.reader.RacingCarReader;
import racingcar.service.RacingCarService;

public class AppConfig {

    public Printer printer() {
        return new RacingCarPrinter();
    }

    public Reader reader() {
        return new RacingCarReader();
    }

    public RacingCarService racingCarService() {
        return new RacingCarService();
    }
}
