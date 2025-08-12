package org.example.notification;

public class NotificationService {
    public void bookingConfirmed(String email, String phone, String bookingId, double amount) {
        System.out.println("[EMAIL] to " + email + " :: Booking " + bookingId + " confirmed. Amount: " + amount);
        System.out.println("[SMS] to " + phone + " :: Booking " + bookingId + " confirmed.");
    }

    public void bookingFailed(String email, String phone, String bookingId) {
        System.out.println("[EMAIL] to " + email + " :: Booking " + bookingId + " failed.");
    }
}
