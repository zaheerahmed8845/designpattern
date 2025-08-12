package org.example.person;

import org.example.entity.Address;

public abstract class Person {
    private String name, email, phone;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String v) {
        name = v;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String v) {
        email = v;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String v) {
        phone = v;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address v) {
        address = v;
    }
}