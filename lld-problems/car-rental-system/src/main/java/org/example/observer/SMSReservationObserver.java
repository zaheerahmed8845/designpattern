package org.example.observer;


import org.example.entity.VehicleReservation;
import org.example.notification.SMSNotification;
import org.example.person.Account;

public class SMSReservationObserver implements ReservationObserver {
    private final Account account;

    public SMSReservationObserver(Account account) {
        this.account = account;
    }

    @Override
    public void onReservationUpdated(VehicleReservation reservation) {
        SMSNotification n = new SMSNotification(reservation.getReservationId(),
                "Reservation update: " + reservation.getStatus());
        n.sendNotification(account);
    }
}
