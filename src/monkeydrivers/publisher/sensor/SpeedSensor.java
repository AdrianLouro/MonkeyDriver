package monkeydrivers.publisher.sensor;

import monkeydrivers.bus.Bus;
import monkeydrivers.message.SpeedMessage;

public class SpeedSensor implements Sensor {
    private final Bus bus;
    private float speed;

    public SpeedSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void sendMessageToBus() {
        bus.send(new SpeedMessage(speed));
    }
}
