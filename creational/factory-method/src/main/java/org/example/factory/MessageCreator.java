package org.example.factory;

import org.example.entity.Message;

public abstract class MessageCreator {

    public Message getMessage() {
        Message msg = createMessage();

        //do additional work before returning
        msg.addDefaultHeaders();
        msg.encrypt();
        return msg;
    }

    //Factory Message
    public abstract Message createMessage();
}
