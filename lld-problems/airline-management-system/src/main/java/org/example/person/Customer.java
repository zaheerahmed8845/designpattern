package org.example.person;

import org.example.component.Itinerary;

import java.util.List;

public class Customer extends Person {
    public String customerId;

    public Customer(String name, String email, String phone) {
        super(name, email, phone);
        this.customerId = "C-" + System.currentTimeMillis();
    }

    public List<Itinerary> viewItinerary() {
        return List.of();
    }
}
