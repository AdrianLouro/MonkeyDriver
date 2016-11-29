package monkeydrivers;

public interface Bus {
    Subscription subscribe(Subscriber subscriber, String... types);
    void send(Message message);

    interface Subscription {

        void to(String... types);
    }
}
