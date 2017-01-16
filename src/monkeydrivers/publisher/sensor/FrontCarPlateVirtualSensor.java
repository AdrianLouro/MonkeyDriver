package monkeydrivers.publisher.sensor;

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
    public Message sendMessageToBus() {

        Message message = new PlateMessage(frontCarPlate);
        bus.send(message);
        return message;
    }

    @Override
    public void receiveMessage(Message message) {

    }
}
