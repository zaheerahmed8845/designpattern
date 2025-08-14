package org.example.notification;

import org.example.person.Person;

public class SMSNotifier implements Notifier {
    @Override
    public void notify(Person person, String message) { /* SMS API */ }
}
