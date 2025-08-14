package org.example.person;

import org.example.entity.Account;
import org.example.entity.Address;
import org.example.enums.AccountType;
import org.example.search.Search;

public abstract class Person implements Search {
    public String name, email, phoneNumber;
    public Address address;
    public AccountType accountType;
    public Account account;
}
