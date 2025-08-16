package org.example.entity;

public class Address {
    public String zipCode;
    public String street;
    public String city;
    public String state;
    public String country;

    public Address() {
    }

    public Address(String street, String city, String state, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }
}
