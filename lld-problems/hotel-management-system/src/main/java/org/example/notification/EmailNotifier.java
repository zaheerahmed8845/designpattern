package org.example.notification;

import org.example.person.Person;

public class EmailNotifier implements Notifier {
    @Override
    public void notify(Person person, String message) { /* Email API */ }
}
