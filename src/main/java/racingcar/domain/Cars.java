package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> value;

    private Cars(List<Car> value) {
        this.value = value;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getValue() {
        return value;
    }
}
