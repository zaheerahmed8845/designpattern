package org.example.person;

import org.example.entity.Address;

public class Person {
    protected String name;
    protected String email;
    protected String phone;
    protected String password; // hash in real systems
    protected Address address;

    protected Person() {
    }

    protected Person(String name, String email, String phone, String password, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
    }
}
