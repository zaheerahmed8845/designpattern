package org.example.entity;

import org.example.observer.FlightInstance;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    public String flightNo;
    public int durationMin;
    public Airport departure;
    public Airport arrival;
    public final List<FlightInstance> instances = new ArrayList<>();

    public Flight(String flightNo, Airport departure, Airport arrival, int durationMin) {
        this.flightNo = flightNo;
        this.departure = departure;
        this.arrival = arrival;
        this.durationMin = durationMin;
    }

    public void addInstance(FlightInstance fi) {
        instances.add(fi);
    }
}
