package org.example.notification;

import org.example.person.Person;

public class NotificationService {
    private final EmailNotification email = new EmailNotification();
    private final PhoneNotification sms = new PhoneNotification();

    public void sendBookingConfirmed(Person person, String bookingId, double amount) {
        email.setContent("Your booking #" + bookingId + " is confirmed. Amount: " + amount);
        email.sendNotification(person);
        sms.setContent("Booking #" + bookingId + " confirmed.");
        sms.sendNotification(person);
    }

    public void sendBookingFailed(Person person, String bookingId) {
        email.setContent("Your booking #" + bookingId + " failed. Please retry.");
        email.sendNotification(person);
    }
}
