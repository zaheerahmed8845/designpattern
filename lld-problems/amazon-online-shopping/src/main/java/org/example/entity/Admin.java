package org.example.entity;

public class Admin {
    private Account account;

    public boolean blockUser() {
        return true;
    }

    public boolean showProductCategory() {
        return true;
    }

    public boolean modifyProductCategory() {
        return true;
    }

    public boolean deleteProductCategory() {
        return true;
    }
}
