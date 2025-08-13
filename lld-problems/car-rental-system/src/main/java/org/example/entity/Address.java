package org.example.entity;

import java.util.Objects;

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, String zip, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address a = (Address) o;
        return Objects.equals(streetAddress, a.streetAddress) &&
                Objects.equals(city, a.city) &&
                Objects.equals(state, a.state) &&
                Objects.equals(zip, a.zip) &&
                Objects.equals(country, a.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, city, state, zip, country);
    }

    @Override
    public String toString() {
        return streetAddress + ", " + city + ", " + state + " " + zip + ", " + country;
    }
}
