package org.example.factory;

import org.example.entity.JSONMessage;
import org.example.entity.Message;

public class JSONMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
