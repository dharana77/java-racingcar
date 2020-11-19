package racing.domain;

import racing.strategy.MoveStrategy;

public class Car implements Comparable {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validName(name);
        this.name = name;
        this.position = 0;
    }

    private void validName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상에 5글자를 초과할 수 없습니다.");
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if (! (o instanceof Car)) {
            return 0;
        }
        Car c = (Car) o;
        return c.getPosition() - this.getPosition();
    }

    public boolean isGreaterOrEqualsPosition(int position) {
        return this.position >= position;
    }
}
