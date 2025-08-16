package org.example.observer;

import org.example.component.FlightReservation;
import org.example.enums.EventType;
import org.example.enums.NotificationType;
import org.example.notification.Notification;
import org.example.notification.NotificationFactory;
import org.example.person.Person;

/**
 * Observer that reacts to reservation/flight events and dispatches template-method notifications.
 */
public class NotificationService implements Observer {
    private final Person recipient;
    private final NotificationType preferred;

    public NotificationService(Person recipient, NotificationType preferred) {
        this.recipient = recipient;
        this.preferred = preferred;
    }

    @Override
    public void onEvent(Subject subject, EventType type, Object payload) {
        String content;
        switch (type) {
            case RESERVATION_CONFIRMED:
                FlightReservation fr = (FlightReservation) payload;
                content = "Reservation " + fr.reservationNumber + " confirmed. Total: $" + fr.getCost();
                break;
            case RESERVATION_CANCELED:
                fr = (FlightReservation) payload;
                content = "Reservation " + fr.reservationNumber + " canceled.";
                break;
            case FLIGHT_DELAYED:
                FlightInstance fi = (FlightInstance) payload;
                content = "Flight " + fi.flight.flightNo + " is delayed.";
                break;
            default:
                content = "Update from Airline System.";
        }
        Notification n = NotificationFactory.create(preferred, content, recipient);
        n.sendNotification(recipient.account);
    }
}
