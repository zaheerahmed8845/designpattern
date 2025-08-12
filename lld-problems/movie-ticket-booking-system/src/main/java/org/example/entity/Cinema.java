package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int cinemaId;
    private String name;
    private Address address;
    private City city;
    private final List<Hall> halls = new ArrayList<>();

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int v) {
        cinemaId = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String v) {
        name = v;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address v) {
        address = v;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City v) {
        city = v;
    }

    public List<Hall> getHalls() {
        return halls;
    }
}
