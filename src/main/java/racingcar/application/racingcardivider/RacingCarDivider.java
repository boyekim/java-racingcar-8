package racingcar.application.racingcardivider;

import java.util.Arrays;
import java.util.List;
import racingcar.application.DivideStrategy;

public class RacingCarDivider implements DivideStrategy {

    private static final String DELIMITER = ",";

    @Override
    public List<String> divideByDelimiter(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }
}
