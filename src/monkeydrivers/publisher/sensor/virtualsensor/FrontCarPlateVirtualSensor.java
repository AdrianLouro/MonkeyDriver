package monkeydrivers.publisher.sensor.virtualsensor;

import monkeydrivers.bus.Bus;
import monkeydrivers.message.Message;
import monkeydrivers.message.PlateMessage;

public class FrontCarPlateVirtualSensor implements VirtualSensor {

    private final Bus bus;
    private String frontCarPlate;

    public FrontCarPlateVirtualSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void sendMessageToBus() {
        bus.send(new PlateMessage(frontCarPlate));
    }

    @Override
    public void receiveMessage(Message message) {

    }
}
