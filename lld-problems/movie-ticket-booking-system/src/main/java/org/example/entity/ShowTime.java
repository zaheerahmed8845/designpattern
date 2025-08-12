package org.example.entity;

import org.example.seat.Seat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ShowTime {
    private final String id;
    private final Movie movie;
    private final LocalDate date;
    private final LocalTime start;
    private final Map<String, Seat> seats = new LinkedHashMap<>();

    public ShowTime(String id, Movie movie, LocalDate date, LocalTime start) {
        this.id = id;
        this.movie = movie;
        this.date = date;
        this.start = start;
    }

    public String id() {
        return id;
    }

    public Movie movie() {
        return movie;
    }

    public LocalDate date() {
        return date;
    }

    public LocalTime start() {
        return start;
    }

    public Collection<Seat> seats() {
        return seats.values();
    }

    public void addSeat(Seat s) {
        seats.put(s.id(), s);
    }

    public Optional<Seat> seat(String seatId) {
        return Optional.ofNullable(seats.get(seatId));
    }
}
