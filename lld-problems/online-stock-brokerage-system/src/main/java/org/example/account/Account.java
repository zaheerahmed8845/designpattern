package org.example.account;

import org.example.entity.Address;
import org.example.enums.AccountStatus;

import java.util.Objects;

public abstract class Account {
    protected String id;
    protected String password;
    protected AccountStatus status;
    protected Address address;
    protected String email;
    protected String phone;

    protected Account(String id,
                      String password,
                      AccountStatus status,
                      Address address,
                      String email,
                      String phone) {
        this.id = Objects.requireNonNull(id);
        this.password = Objects.requireNonNull(password);
        this.status = Objects.requireNonNull(status);
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public boolean login(String pwd) {
        return status == AccountStatus.ACTIVE && Objects.equals(this.password, pwd);
    }

    public void resetPassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    public String getId() {
        return id;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
