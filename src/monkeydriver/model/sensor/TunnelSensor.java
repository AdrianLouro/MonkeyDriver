package monkeydriver.model.sensor;

import monkeydriver.model.bus.Bus;

/**
 * Created by gerardo on 22/11/2016.
 */
public class TunnelSensor implements Sensor{

    Bus bus;
    boolean tunnelIsComing;

    public TunnelSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void sendInfoToBus() {
        bus.setTunnelIsComing(tunnelIsComing);
    }
}
