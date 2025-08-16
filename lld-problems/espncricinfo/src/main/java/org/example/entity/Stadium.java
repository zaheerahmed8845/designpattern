package org.example.entity;

public class Stadium {
    public String name;
    public Address location;
    public int maxCapacity;

    public Stadium(String name, Address location, int maxCapacity) {
        this.name = name;
        this.location = location;
        this.maxCapacity = maxCapacity;
    }
}