package org.example.entity.account;

import org.example.entity.Person;
import org.example.enums.AccountStatus;

public abstract class Account {
    String userName;
    String password;
    AccountStatus status;
    Person person;

    public boolean resetPassword() {
        return true;
    }
}
