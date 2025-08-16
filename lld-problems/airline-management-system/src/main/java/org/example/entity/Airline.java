package org.example.entity;

import org.example.person.Crew;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    public String name;
    public String code;
    public final List<Flight> flights = new ArrayList<>();
    public final List<Aircraft> fleet = new ArrayList<>();
    public final List<Crew> crew = new ArrayList<>();

    public Airline(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void addFlight(Flight f) {
        flights.add(f);
    }

    public void addAircraft(Aircraft a) {
        fleet.add(a);
    }

    public void addCrew(Crew c) {
        crew.add(c);
    }
}
