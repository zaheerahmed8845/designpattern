package org.example.observer;

import org.example.entity.VehicleReservation;
import org.example.notification.EmailNotification;
import org.example.person.Account;

public class EmailReservationObserver implements ReservationObserver {
    private final Account account;

    public EmailReservationObserver(Account account) {
        this.account = account;
    }

    @Override
    public void onReservationUpdated(VehicleReservation reservation) {
        EmailNotification n = new EmailNotification(reservation.getReservationId(),
                "Reservation update: " + reservation.getStatus());
        n.sendNotification(account);
    }
}
