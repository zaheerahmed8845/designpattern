package org.example.entity;

import org.example.enums.AccountStatus;

public class Account {
    public String username;
    public String password;
    public AccountStatus status = AccountStatus.ACTIVE;

    public boolean resetPassword() {
        // stub
        System.out.println("Password reset requested for user: " + username);
        return true;
    }
}
