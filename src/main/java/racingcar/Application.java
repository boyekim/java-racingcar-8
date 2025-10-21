package racingcar;

import racingcar.application.RacingCarApplication;
import racingcar.application.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingCarApplication racingCarApplication = new RacingCarApplication(appConfig);
        racingCarApplication.run();
    }
}
