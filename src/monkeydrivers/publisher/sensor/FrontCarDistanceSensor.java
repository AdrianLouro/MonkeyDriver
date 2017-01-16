package monkeydrivers.publisher.sensor;

import monkeydrivers.bus.Bus;
import monkeydrivers.device.DistanceDevice;
import monkeydrivers.message.DistanceMessage;
import monkeydrivers.message.Message;

public class FrontCarDistanceSensor implements Sensor {
    private final Bus bus;
    private DistanceDevice distanceDevice;
    private float frontCarDistance;

    public FrontCarDistanceSensor(Bus bus, DistanceDevice distanceDevice) {
        this.bus = bus;
        this.distanceDevice = distanceDevice;
    }

    @Override
    public Message sendMessageToBus() {
        DistanceMessage distanceMessage = null;
        if (frontCarDistance != -1) {
            distanceMessage = new DistanceMessage(frontCarDistance);
            bus.send(distanceMessage);
        }
        return distanceMessage;
    }

    public void askDeviceForNewValue() {
        frontCarDistance = distanceDevice.getDistance();
    }
}
