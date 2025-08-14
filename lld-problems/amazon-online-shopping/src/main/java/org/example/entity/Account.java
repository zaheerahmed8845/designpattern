package org.example.entity;

import org.example.enums.AccountStatus;
import org.example.payment.CreditCard;
import org.example.payment.ElectronicBankTransfer;
import org.example.product.Product;
import org.example.product.ProductReview;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private AccountStatus status = AccountStatus.Inactive;
    private Instant createdOn = Instant.now();
    private final List<Address> shippingAddress = new ArrayList<>();
    private final List<CreditCard> creditCards = new ArrayList<>();
    private final List<ElectronicBankTransfer> bankTransfers = new ArrayList<>();

    public boolean addProduct(Product product) {
        return true;
    }

    public boolean deleteProduct(Product product) {
        return true;
    }

    public boolean deleteProductReview(ProductReview review) {
        return true;
    }

    public boolean resetPassword() {
        return true;
    }

    // getters/setters
}
