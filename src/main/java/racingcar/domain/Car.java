package racingcar.domain;

public class Car {
    private final String name;
    private final Distance distance;

    private Car(String name) {
        this.name = name;
        this.distance = new Distance();
    }

    public static Car of(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        return new Car(name);
    }

    public void move(boolean canMove) {
        if (canMove) {
            distance.goForward();
        }
    }

    public String buildResult() {
        StringBuilder distanceResult = new StringBuilder(name);
        distanceResult.append(" : ");
        for (int i = 0; i < distance.getValue(); i++) {
            distanceResult.append("-");
        }
        return distanceResult.toString();
    }

    public String getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }
}
