package monkeydrivers.subscriber;

import monkeydrivers.message.Message;

public interface Subscriber {
    void receiveMessage(Message message);
}
