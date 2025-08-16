package org.example.component;

import org.example.entity.Airport;
import org.example.person.Passenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Itinerary implements ItineraryComponent {
    public Airport startingAirport;
    public Airport finalAirport;
    public LocalDateTime creationDate = LocalDateTime.now();
    public final List<FlightReservation> reservations = new ArrayList<>();
    public final List<Passenger> passengers = new ArrayList<>();

    @Override
    public double getCost() {
        return reservations.stream().mapToDouble(FlightReservation::getCost).sum();
    }

    public void addReservation(FlightReservation r) {
        reservations.add(r);
    }

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }
}
