package racingcar.application;

import racingcar.application.config.AppConfig;

public class RacingCarApplication {

    public final Printer printer;
    public final Reader reader;

    public RacingCarApplication(AppConfig appConfig) {
        printer = appConfig.printer();
        reader = appConfig.reader();
    }

    public void run() {
        printer.printStartingMessage();
        String carNamesInput = reader.read();
    }
}
