package org.example.person;

import org.example.entity.Account;
import org.example.entity.Address;

public abstract class Person {
    public String name;
    public Address address;
    public String email;
    public String phone;
    public Account account;

    public Person() {
    }

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = new Account();
        this.account.username = email;
    }
}
