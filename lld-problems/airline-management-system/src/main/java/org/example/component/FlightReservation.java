package org.example.component;

import org.example.entity.FlightSeat;
import org.example.enums.EventType;
import org.example.enums.ReservationStatus;
import org.example.enums.SeatStatus;
import org.example.observer.FlightInstance;
import org.example.observer.Observer;
import org.example.observer.Subject;
import org.example.person.Passenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightReservation implements ItineraryComponent, Subject {
    public String reservationNumber;
    public FlightInstance flightInstance;
    public Map<Passenger, FlightSeat> seats = new HashMap<>();
    public ReservationStatus status = ReservationStatus.PENDING;
    public LocalDateTime creationDate = LocalDateTime.now();

    private final List<Observer> observers = new ArrayList<>();

    public FlightReservation(String reservationNumber, FlightInstance fi) {
        this.reservationNumber = reservationNumber;
        this.flightInstance = fi;
    }

    public void assignSeat(Passenger p, FlightSeat s) {
        seats.put(p, s);
        s.status = SeatStatus.BOOKED;
        s.reservationNumber = reservationNumber;
    }

    public void confirm() {
        status = ReservationStatus.CONFIRMED;
        notifyObservers(EventType.RESERVATION_CONFIRMED, this);
    }

    public void cancel() {
        status = ReservationStatus.CANCELED;
        notifyObservers(EventType.RESERVATION_CANCELED, this);
    }

    @Override
    public double getCost() {
        return seats.values().stream().mapToDouble(fs -> fs.fare).sum();
    }

    // Subject
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(EventType type, Object payload) {
        for (Observer o : observers) o.onEvent(this, type, payload);
    }
}
