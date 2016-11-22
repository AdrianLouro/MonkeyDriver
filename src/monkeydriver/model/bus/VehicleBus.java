package monkeydriver.model.bus;

/**
 * Created by usuario on 22/11/2016.
 */
public class VehicleBus implements Bus {

    float speed;
    int luminosity;
    boolean tunnelIsComing;
    float nextCarDistance;
    float previousCarDistance;

    public VehicleBus(float speed, int luminosity, boolean tunnelIsComing, float nextCarDistance, float previousCarDistance) {
        this.speed = speed;
        this.luminosity = luminosity;
        this.tunnelIsComing = tunnelIsComing;
        this.nextCarDistance = nextCarDistance;
        this.previousCarDistance = previousCarDistance;
    }

    @Override
    public void setSpeed(float speed) {

    }

    @Override
    public void setLuminosity(int luminosity) {

    }

    @Override
    public void setTunnelIsComing(boolean tunnelIsComing) {

    }

    @Override
    public void setNextCarDistance(float nextCarDistance) {

    }

    @Override
    public void setPreviousCarDistance(float previousCarDistance) {

    }
}
