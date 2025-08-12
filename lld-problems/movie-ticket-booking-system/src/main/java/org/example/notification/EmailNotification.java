package org.example.notification;

import org.example.entity.Person;

public class EmailNotification extends Notification {
    public void sendNotification(Person p) {
        System.out.println("[EMAIL] " + p.getEmail() + " :: " + getContent());
    }
}

