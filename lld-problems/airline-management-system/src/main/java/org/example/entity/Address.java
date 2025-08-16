package org.example.entity;

public class Address {
    public String zipCode;
    public String streetAddress;
    public String city;
    public String state;
    public String country;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, String zipCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
}
