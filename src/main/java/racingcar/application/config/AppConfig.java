package racingcar.application.config;

import racingcar.application.ForwardStrategy;
import racingcar.application.Printer;
import racingcar.application.Reader;
import racingcar.application.numbergenerator.RacingCarForwardStrategy;
import racingcar.application.printer.RacingCarPrinter;
import racingcar.application.reader.RacingCarReader;
import racingcar.service.RacingCarService;
import racingcar.service.RacingService;

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

    public ForwardStrategy forwardStrategy() {
        return new RacingCarForwardStrategy();
    }

    public RacingService racingService() {
        return new RacingService(forwardStrategy());
    }
}
