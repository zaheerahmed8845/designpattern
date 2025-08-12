package org.example.notification;

import org.example.entity.Person;

public class PhoneNotification extends Notification {
    public void sendNotification(Person p) {
        System.out.println("[SMS] " + p.getPhone() + " :: " + getContent());
    }
}

