package org.example.person;

import org.example.observer.FlightInstance;

import java.util.List;

public class Crew extends Person {
    public Crew(String name, String email, String phone) {
        super(name, email, phone);
    }

    public List<FlightInstance> viewSchedule() {
        return List.of();
    }
}
