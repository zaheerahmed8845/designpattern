package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    public String code;
    public String name;
    public Address address;
    public final List<Flight> flights = new ArrayList<>();

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
