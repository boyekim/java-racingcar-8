package racingcar.domain;

public class Distance {
    private Integer value;

    public Distance() {
        this.value = 0;
    }

    public void goForward() {
        value++;
    }

    public Integer getValue() {
        return value;
    }
}
