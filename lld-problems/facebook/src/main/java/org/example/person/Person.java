package org.example.person;

import org.example.entity.Address;

import java.util.UUID;

public abstract class Person {
    protected final String id;
    protected String name, email, phone;
    protected Address address;

    protected Person(String name) {
        this.id = "id-" + UUID.randomUUID();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
