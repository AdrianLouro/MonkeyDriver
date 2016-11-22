package monkeydriver.model.bus;

/**
 * Created by gerardo on 22/11/2016.
 */
public interface Bus {

    void setSpeed(float speed);
    void setLuminosity(int luminosity);
    void setTunnelIsComing(boolean tunnelIsComing);
    void setNextCarDistance(float nextCarDistance);
    void setPreviousCarDistance(float previousCarDistance);

}
