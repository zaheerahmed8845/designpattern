package org.example.entity;

import java.util.Objects;

public class Address {
    private String zipCode;
    private String streetAddress;
    private String city;
    private String state;
    private String country;

    public Address(String zipCode, String streetAddress, String city, String state, String country) {
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getZipCode() {
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

    @Override
    public String toString() {
        return streetAddress + ", " + city + ", " + state + " " + zipCode + ", " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address a)) return false;
        return Objects.equals(zipCode, a.zipCode) && Objects.equals(streetAddress, a.streetAddress)
                && Objects.equals(city, a.city) && Objects.equals(state, a.state) && Objects.equals(country, a.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, streetAddress, city, state, country);
    }
}
