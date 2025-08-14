package org.example.entity;

import org.example.enums.AccountStatus;

public class Account {
    public String id, password;
    public AccountStatus status = AccountStatus.Active;

    public boolean resetPassword() {
        return true;
    }
}
