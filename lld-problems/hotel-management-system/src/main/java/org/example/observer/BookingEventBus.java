package org.example.observer;

import org.example.entity.RoomBookingEvent;

import java.util.ArrayList;
import java.util.List;

public class BookingEventBus implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private RoomBookingEvent lastEvent;

    @Override
    public void attach(Observer o) {
        if (o != null) observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (var o : observers) o.update(lastEvent);
    }

    public void publish(RoomBookingEvent event) {
        this.lastEvent = event;
        notifyObservers();
    }
}
