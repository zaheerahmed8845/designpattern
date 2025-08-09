package org.example.entity;

public class Person {
    private final String name;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String country;

    public Person(String name, String streetAddress, String city, String state, String country) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
