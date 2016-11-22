package monkeydriver.model.sensor;

import monkeydriver.model.bus.Bus;

/**
 * Created by gerardo on 22/11/2016.
 */
public class DistanceSensor implements Sensor{

    public enum Direction {
        FRONT(0), BACK(1), LEFT(2), RIGHT(3);
        private int value;
        private Direction(int value) { this.value = value; }
    }

    Bus bus;
    Direction direction;
    float distance;

    public DistanceSensor(Bus bus, int direction) {
        this.bus = bus;
        switch (direction) {
            case 0: this.direction = Direction.BACK;
            case 1: this.direction = Direction.FRONT;
            case 2: this.direction = Direction.LEFT;
            case 3: this.direction = Direction.RIGHT;
        }
    }

    @Override
    public void sendInfoToBus() {
        switch (direction) {
            case BACK: bus.setNextCarDistance(distance); break;
            case FRONT: bus.setPreviousCarDistance(distance); break;
        }
    }
}
