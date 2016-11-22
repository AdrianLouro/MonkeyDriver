package monkeydriver.model.sensor;

import monkeydriver.model.bus.Bus;

/**
 * Created by gerardo on 22/11/2016.
 */
public class LuminositySensor implements Sensor{

    Bus bus;
    int luminosity;

    public LuminositySensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void sendInfoToBus() {
        bus.setLuminosity(luminosity);
    }
}
