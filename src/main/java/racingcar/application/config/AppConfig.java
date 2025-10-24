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
import racingcar.service.CarApplication;
import racingcar.service.RaceApplication;
import racingcar.application.numbergenerator.RandomNumberGenerator;

public class AppConfig {

    public Printer printer() {
        return new RacingCarPrinter();
    }

    public Reader reader() {
        return new RacingCarReader();
    }

    public CarApplication racingCarService() {
        return new CarApplication(divideStrategy());
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator();
    }

    public ForwardStrategy forwardStrategy() {
        return new RacingCarForwardStrategy(numberGenerator());
    }

    public RaceApplication racingService() {
        return new RaceApplication(forwardStrategy());
    }

    public DivideStrategy divideStrategy() {
        return new RacingCarDivider();
    }
}
