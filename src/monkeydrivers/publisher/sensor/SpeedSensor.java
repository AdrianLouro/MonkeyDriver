package monkeydrivers.publisher.sensor;

import monkeydrivers.bus.Bus;
import monkeydrivers.message.Message;
import monkeydrivers.message.SpeedMessage;

public class SpeedSensor implements Sensor {
    private final Bus bus;
    private float speed;

    public SpeedSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public Message sendMessageToBus() {
        Message message = new SpeedMessage(speed);
        bus.send(message);
        return message;
    }
}
