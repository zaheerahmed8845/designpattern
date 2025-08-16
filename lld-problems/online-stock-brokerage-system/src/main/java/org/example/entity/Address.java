package org.example.entity;

public final class Address {
    private final int zipCode;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final String country;

    public Address(int zipCode, String streetAddress, String city, String state, String country) {
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
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
