package monkeydrivers.publisher.sensor.virtualsensor;

import monkeydrivers.bus.Bus;
import monkeydrivers.message.DistanceMessage;
import monkeydrivers.message.Message;
import monkeydrivers.message.PlateMessage;
import monkeydrivers.message.SpeedMessage;
import monkeydrivers.publisher.sensor.SpeedSensor;

import java.util.HashMap;
import java.util.Map;

public class FrontCarSpeedVirtualSensor implements VirtualSensor {

    private final Bus bus;
    private float frontCarSpeed;

    private Map<Long,Measurement> measurements = new HashMap<>();

    public FrontCarSpeedVirtualSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void sendMessageToBus() {
        bus.send(new SpeedMessage(frontCarSpeed));
    }

    @Override
    public void receiveMessage(Message message) {
        long timeMark = System.currentTimeMillis()/1000;
        if (measurements.get(timeMark) != null) measurements.put(timeMark, createMeasurement(message));
        else measurements.put(timeMark, updateMeasurement(message, measurements.get(timeMark)));
    }

    private Measurement updateMeasurement(Message message, Measurement measurement) {
        if (message.type().equals("speed")) measurement.setSpeed(((SpeedMessage)message).getSpeed());
        else if (message.type().equals("distance")) measurement.setFrontCarDistance(((DistanceMessage)message).getDistance());
        else if (message.type().equals("plate")) measurement.setFrontCarPlate(((PlateMessage)message).getPlate());
        return measurement;
    }

    private Measurement createMeasurement(Message message) {
//        if (message.type().equals("speed")) return new Measurement(((SpeedMessage) message).getSpeed(), 0f, "");
//        else if (message.type().equals("distance")) return new Measurement(0f, ((SpeedMessage) message).getSpeed(), "");
//        else if (message.type().equals("plate")) return new Measurement(((SpeedMessage) message).getSpeed(), 0f, "");
        return null;
    }

    private class Measurement {
        public void setSpeed(float speed) {
            this.speed = speed;
        }

        public void setFrontCarDistance(float frontCarDistance) {
            this.frontCarDistance = frontCarDistance;
        }

        public void setFrontCarPlate(String frontCarPlate) {
            this.frontCarPlate = frontCarPlate;
        }

        public Measurement(float speed, float frontCarDistance, String frontCarPlate) {
            this.speed = speed;
            this.frontCarDistance = frontCarDistance;
            this.frontCarPlate = frontCarPlate;
        }

        float speed;
        float frontCarDistance;
        String frontCarPlate;

    }
}
