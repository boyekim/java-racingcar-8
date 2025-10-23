package racingcar;

import racingcar.application.GameApplication;
import racingcar.application.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameApplication gameApplication = new GameApplication(appConfig);
        gameApplication.run();
    }
}
