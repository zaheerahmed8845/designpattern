package org.example.notification;

import org.example.person.Person;

public interface Notifier {
    void notify(Person person, String message);
}
