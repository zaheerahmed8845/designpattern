package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    public String name;
    public String code;
    public String model;
    public int seatsCapacity;
    public final List<Seat> seats = new ArrayList<>();

    public Aircraft(String code, String model, int capacity) {
        this.code = code;
        this.model = model;
        this.seatsCapacity = capacity;
    }
}
