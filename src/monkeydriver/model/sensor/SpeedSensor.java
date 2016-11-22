package monkeydriver.model.sensor;

import monkeydriver.model.bus.Bus;

/**
 * Created by gerardo on 22/11/2016.
 */
public class SpeedSensor implements Sensor{

    Bus bus;
    float speed;

    public SpeedSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void sendInfoToBus() {
        bus.setSpeed(speed);
    }
}
