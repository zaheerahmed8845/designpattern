package org.example.component;

import org.example.entity.Airport;
import org.example.person.Passenger;

public class ItineraryBuilder {
    private final Itinerary itinerary = new Itinerary();

    public ItineraryBuilder startingAirport(Airport a) {
        itinerary.startingAirport = a;
        return this;
    }

    public ItineraryBuilder finalAirport(Airport a) {
        itinerary.finalAirport = a;
        return this;
    }

    public ItineraryBuilder addPassenger(Passenger p) {
        itinerary.addPassenger(p);
        return this;
    }

    public ItineraryBuilder addReservation(FlightReservation r) {
        itinerary.addReservation(r);
        return this;
    }

    public Itinerary build() {
        return itinerary;
    }
}
