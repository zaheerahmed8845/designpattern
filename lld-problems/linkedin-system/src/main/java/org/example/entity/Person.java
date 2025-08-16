package org.example.entity;

public abstract class Person {
    protected String name;
    protected Address address;
    protected String phone;
    protected String email;
    protected String password;

    protected Person(String name, Address address, String phone, String email, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
