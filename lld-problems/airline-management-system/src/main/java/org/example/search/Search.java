package org.example.search;

import org.example.entity.Airport;
import org.example.observer.FlightInstance;

import java.time.LocalDate;
import java.util.List;

public interface Search {
    List<FlightInstance> searchFlights(String flightNoOrSource, Airport from, Airport to, LocalDate date);
}
