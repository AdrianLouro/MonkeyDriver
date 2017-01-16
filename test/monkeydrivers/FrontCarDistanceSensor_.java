package monkeydrivers;

import monkeydrivers.bus.Bus;
import monkeydrivers.bus.SimpleBus;
import monkeydrivers.device.DistanceDevice;
import monkeydrivers.message.Message;
import monkeydrivers.publisher.sensor.*;
import monkeydrivers.subscriber.Subscriber;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class FrontCarDistanceSensor_ {
    private Bus bus;

    @Before
    public void setUp() throws Exception {
        bus = new SimpleBus();
    }

    @Test
    public void should_set_message_to_bus_when_device_returns_distance() throws Exception {

        Subscriber subscriberDistance = mock(Subscriber.class);
        bus.subscribe(subscriberDistance).to("distance");

        DistanceDevice distanceDevice = mock(DistanceDevice.class);

        FrontCarDistanceSensor frontCarDistanceSensor = new FrontCarDistanceSensor(bus, distanceDevice);
        when(distanceDevice.getDistance()).thenReturn(10f);

        frontCarDistanceSensor.askDeviceForNewValue();
        Message message = frontCarDistanceSensor.sendMessageToBus();

        verify(subscriberDistance,times(1)).receiveMessage(message);
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
