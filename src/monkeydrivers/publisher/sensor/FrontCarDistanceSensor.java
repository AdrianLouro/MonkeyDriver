package monkeydrivers.publisher.sensor;

import monkeydrivers.bus.Bus;
import monkeydrivers.message.DistanceMessage;

public class FrontCarDistanceSensor implements Sensor {
    private final Bus bus;
    private float frontCarDistance;

    public FrontCarDistanceSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void sendMessageToBus() {
        bus.send(new DistanceMessage(frontCarDistance));
    }
}
