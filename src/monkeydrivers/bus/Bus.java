package monkeydrivers.bus;

import monkeydrivers.message.Message;
import monkeydrivers.subscriber.Subscriber;

public interface Bus {
    Subscription subscribe(Subscriber subscriber, String... types);
    void send(Message message);

    interface Subscription {

        void to(String... types);
    }
}
