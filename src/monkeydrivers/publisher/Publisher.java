package monkeydrivers.publisher;

import monkeydrivers.message.Message;

public interface Publisher {
    Message sendMessageToBus();
}
