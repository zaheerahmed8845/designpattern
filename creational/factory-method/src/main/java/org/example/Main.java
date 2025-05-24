package org.example;

import org.example.entity.Message;
import org.example.factory.JSONMessageCreator;
import org.example.factory.MessageCreator;
import org.example.factory.TextMessageCreator;

public class Main {
    public static void main(String[] args) {
        printMessage(new JSONMessageCreator());

        printMessage(new TextMessageCreator());
    }

    public static void printMessage(MessageCreator messageCreator){
        Message message = messageCreator.createMessage();
        System.out.println(message);
    }
}