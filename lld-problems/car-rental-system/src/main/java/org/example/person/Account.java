package org.example.person;

import org.example.enums.AccountStatus;

public abstract class Account {
    private String accountId;
    private String password;
    private AccountStatus status = AccountStatus.Active;

    public Account(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public boolean resetPassword() {
        return true;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
