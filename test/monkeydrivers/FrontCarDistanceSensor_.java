package monkeydrivers;

import monkeydrivers.bus.Bus;
import monkeydrivers.bus.SimpleBus;
import monkeydrivers.device.DistanceDevice;
import monkeydrivers.message.DistanceMessage;
import monkeydrivers.message.Message;
import monkeydrivers.publisher.sensor.*;
import monkeydrivers.subscriber.Subscriber;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.*;

public class FrontCarDistanceSensor_ {
    private Bus bus;
    private DistanceDevice distanceDevice;
    private FrontCarDistanceSensor frontCarDistanceSensor;

    @Before
    public void setUp() throws Exception {
        bus = mock(Bus.class);
        distanceDevice = mock(DistanceDevice.class);
        frontCarDistanceSensor = new FrontCarDistanceSensor(bus, distanceDevice);
    }

    @Test
    public void should_set_message_to_bus_when_device_returns_distance() throws Exception {
        when(distanceDevice.getDistance()).thenReturn(10f);
        sleep(5000);

        verify(distanceDevice,times(4)).getDistance();
        verify(bus,times(4)).send(any(DistanceMessage.class));
    }

    @Test
    public void should_not_set_message_to_bus_when_device_returns_minusone() throws Exception {

        Subscriber subscriberDistance = mock(Subscriber.class);
        bus.subscribe(subscriberDistance).to("distance");

        DistanceDevice distanceDevice = mock(DistanceDevice.class);

        FrontCarDistanceSensor frontCarDistanceSensor = new FrontCarDistanceSensor(bus, distanceDevice);
        when(distanceDevice.getDistance()).thenReturn(-1f);

        frontCarDistanceSensor.askDeviceForNewValue();
        Message message = frontCarDistanceSensor.sendMessageToBus();

        verify(subscriberDistance,times(0)).receiveMessage(message);
    }
}
