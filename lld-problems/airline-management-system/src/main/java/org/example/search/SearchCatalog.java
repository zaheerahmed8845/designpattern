package org.example.search;

import org.example.entity.Airport;
import org.example.observer.FlightInstance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCatalog implements Search {
    private static final SearchCatalog INSTANCE = new SearchCatalog();

    private SearchCatalog() {
    }

    public static SearchCatalog getInstance() {
        return INSTANCE;
    }

    private final List<FlightInstance> index = new ArrayList<>();

    public void addFlight(FlightInstance fi) {
        index.add(fi);
    }

    public String generateKey(Airport src, Airport dest, LocalDate date) {
        return (src.code + "-" + dest.code + "-" + date).toUpperCase();
    }

    @Override
    public List<FlightInstance> searchFlights(String keyOrFlightNo, Airport from, Airport to, LocalDate date) {
        if (keyOrFlightNo != null && !keyOrFlightNo.isBlank()) {
            return index.stream()
                    .filter(fi -> fi.flight.flightNo.equalsIgnoreCase(keyOrFlightNo))
                    .collect(Collectors.toList());
        }
        String k = generateKey(from, to, date);
        return index.stream()
                .filter(fi -> fi.flight.departure == from && fi.flight.arrival == to
                        && fi.departureTime.toLocalDate().equals(date))
                .collect(Collectors.toList());
    }
}
