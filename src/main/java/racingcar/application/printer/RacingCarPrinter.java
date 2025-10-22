package racingcar.application.printer;

import java.util.List;
import racingcar.application.Printer;
import racingcar.domain.Car;

public class RacingCarPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printFormat(String format, String message) {
        System.out.printf(format, message);
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }

    @Override
    public void printStartingMessage() {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printCountMessage() {
        print("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void printEachResult(List<Car> carsAfterRace) {
        for (Car car : carsAfterRace) {
            print(car.buildResult());
        }
        printNewLine();
    }

    @Override
    public void printWinners(String winnerNames) {
        printFormat("최종 우승자 : %s", winnerNames);
    }
}
