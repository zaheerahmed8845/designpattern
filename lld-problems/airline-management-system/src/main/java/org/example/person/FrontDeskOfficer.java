package org.example.person;


import org.example.component.Itinerary;

import java.util.List;

public class FrontDeskOfficer extends Person {
    public FrontDeskOfficer(String name, String email, String phone) {
        super(name, email, phone);
    }

    public List<Itinerary> viewItinerary() {
        return List.of();
    }
}