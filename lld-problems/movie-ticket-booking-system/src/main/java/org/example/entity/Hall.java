package org.example.entity;

import org.example.entity.seat.Seat;

import java.util.ArrayList;
import java.util.List;

public class Hall {
    private int hallId;
    private String name;
    private final List<Seat> seats = new ArrayList<>();

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int v) {
        hallId = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String v) {
        name = v;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
