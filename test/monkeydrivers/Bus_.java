package monkeydrivers;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class Bus_ {
    private Bus bus;

    @Before
    public void setUp() throws Exception {
        bus = new SimpleBus();
    }

    @Test
    public void should_send_messages_associated_to_subscriber() throws Exception {
        Subscriber subscriberFoo = mock(Subscriber.class);

        Message foo = mock(Message.class);
        when(foo.type()).thenReturn("foo");

        Message fii = mock(Message.class);
        when(fii.type()).thenReturn("fii");

        bus.subscribe(subscriberFoo).to("foo");
        bus.send(foo);
        bus.send(fii);

        verify(subscriberFoo).receive(foo);
        verify(subscriberFoo, times(0)).receive(fii);
    }

    @Test
    public void should_send_only_the_messages_associated_to_all_subscribers() throws Exception {
        Subscriber subscriberFoo = mock(Subscriber.class);
        Subscriber subscriberFii = mock(Subscriber.class);

        Message foo = mock(Message.class);
        when(foo.type()).thenReturn("foo");

        Message fii = mock(Message.class);
        when(fii.type()).thenReturn("fii");

        bus.subscribe(subscriberFoo, "foo");
        bus.subscribe(subscriberFii, "fii");
        bus.send(foo);
        bus.send(fii);

        verify(subscriberFoo).receive(foo);
        verify(subscriberFoo, times(0)).receive(fii);
        verify(subscriberFii).receive(fii);
        verify(subscriberFii, times(0)).receive(foo);
    }
}
