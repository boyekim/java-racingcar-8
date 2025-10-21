package racingcar.application;

import racingcar.application.config.AppConfig;

public class RacingCarApplication {

    public final Printer printer;

    public RacingCarApplication(AppConfig appConfig) {
        printer = appConfig.printer();
    }

    public void run() {
        printer.printStartingMessage();
    }
}
