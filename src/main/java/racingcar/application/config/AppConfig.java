package racingcar.application.config;

import racingcar.application.DivideStrategy;
import racingcar.application.ForwardStrategy;
import racingcar.application.NumberGenerator;
import racingcar.application.Printer;
import racingcar.application.Reader;
import racingcar.application.numbergenerator.RacingCarForwardStrategy;
import racingcar.application.printer.RacingCarPrinter;
import racingcar.application.racingcardivider.RacingCarDivider;
import racingcar.application.reader.RacingCarReader;
import racingcar.service.RacingCarService;
import racingcar.service.RacingService;
import racingcar.util.RandomNumberGenerator;

public class AppConfig {

    public Printer printer() {
        return new RacingCarPrinter();
    }

    public Reader reader() {
        return new RacingCarReader();
    }

    public RacingCarService racingCarService() {
        return new RacingCarService(divideStrategy());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

    public ForwardStrategy forwardStrategy() {
        return new RacingCarForwardStrategy(numberGenerator());
    }

    public RacingService racingService() {
        return new RacingService(forwardStrategy());
    }

    public DivideStrategy divideStrategy() {
        return new RacingCarDivider();
    }
}
