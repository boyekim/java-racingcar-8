package racingcar.application.printer;

import java.util.List;
import racingcar.application.Printer;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;

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
    public void printResult(RacingResult racingResult) {
        List<Cars> allResult = racingResult.getValue();
        printNewLine();
        print("실행 결과");
        for (Cars cars : allResult) {
            printEachResult(cars);
        }
        printFinalWinners(racingResult.findWinners());
    }

    public void printEachResult(Cars cars) {
        List<Car> allCar = cars.getValue();
        for (Car car : allCar) {
            print(makeResultOutput(car));
        }
        printNewLine();
    }

    private String makeResultOutput(Car car) {
        return car.getName() + " : " + "-".repeat(Math.max(0, car.getDistance()));
    }

    private void printFinalWinners(List<String> finalWinners) {
        print("최종 우승자 : " + String.join(", ", finalWinners));
    }
}
