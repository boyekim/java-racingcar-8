package racingcar.application.reader;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.Reader;

public class RacingCarReader implements Reader {
    @Override
    public String read() {
        return Console.readLine();
    }
}
