package org.example.entity;

public class Address {
    private String zipcode;
    private String address;
    private String city;
    private String state;
    private String country;

    public Address() {
    }

    public Address(String zipcode, String address, String city, String state, String country) {
        this.zipcode = zipcode;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getFullAddress() {
        return String.join(", ",
                notNull(address), notNull(city), notNull(state), notNull(zipcode), notNull(country));
    }

    private static String notNull(String s) {
        return s == null ? "" : s;
    }

    // getters/setters omitted for brevity
}
