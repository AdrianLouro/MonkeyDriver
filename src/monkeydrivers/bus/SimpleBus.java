package monkeydrivers.bus;

import monkeydrivers.message.Message;
import monkeydrivers.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBus implements Bus {

    private final Map<String,List<Subscriber>> subscribers = new HashMap<>();

    @Override
    public Subscription subscribe(Subscriber subscriber, String... types) {
        return types1 -> { for (String type: types1) subscribersOf(type).add(subscriber); };
    }

    @Override
    public void send(Message message) {
        subscribersOf(message.type()).forEach(s->s.receiveMessage(message));
    }

    private List<Subscriber> subscribersOf(String type) {
        createIfNotExistsSubscribersOf(type);
        return subscribers.get(type);
    }

    private void createIfNotExistsSubscribersOf(String type) {
        if (subscribers.containsKey(type)) return;
        subscribers.put(type, new ArrayList<>());
    }


}
