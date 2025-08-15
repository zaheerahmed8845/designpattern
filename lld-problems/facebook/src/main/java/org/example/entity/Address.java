package org.example.entity;

public class Address {
    public String zipCode, houseNo, street, city, state, country;

    public Address(String zipCode, String houseNo, String street, String city, String state, String country) {
        this.zipCode = zipCode;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
