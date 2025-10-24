package racingcar.application.racingcardivider;

import java.util.Arrays;
import java.util.List;
import racingcar.application.DivideStrategy;
import racingcar.exception.RacingCarErrorCode;
import racingcar.exception.RacingCarException;

public class RacingCarDivider implements DivideStrategy {

    private static final String DELIMITER = ",";

    @Override
    public List<String> divideByDelimiter(String input) {
        List<String> dividedNames = Arrays.stream(input.split(DELIMITER)).toList();
        validateDuplicatedNames(dividedNames);
        return dividedNames;
    }

    private void validateDuplicatedNames(List<String> dividedNames) {
        if (dividedNames.size() != dividedNames.stream().distinct().count()) {
            throw new RacingCarException(RacingCarErrorCode.DUPLICATED_NAME);
        }
    }
}
