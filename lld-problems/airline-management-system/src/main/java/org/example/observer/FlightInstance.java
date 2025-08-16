package org.example.observer;

import org.example.entity.Aircraft;
import org.example.entity.Flight;
import org.example.entity.FlightSeat;
import org.example.enums.EventType;
import org.example.enums.FlightStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightInstance implements Subject {
    public Flight flight;
    public LocalDateTime departureTime;
    public FlightStatus status = FlightStatus.SCHEDULED;
    public Aircraft aircraft;
    public final List<FlightSeat> seats = new ArrayList<>();

    private final List<Observer> observers = new ArrayList<>();

    public FlightInstance(Flight flight, LocalDateTime departureTime, Aircraft aircraft) {
        this.flight = flight;
        this.departureTime = departureTime;
        this.aircraft = aircraft;
    }

    public void addSeat(FlightSeat s) {
        seats.add(s);
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
        if (status == FlightStatus.DELAYED) {
            notifyObservers(EventType.FLIGHT_DELAYED, this);
        }
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
