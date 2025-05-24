package org.example.factory;

import org.example.entity.Message;
import org.example.entity.TextMessage;

public class TextMessageCreator extends MessageCreator{
    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}
