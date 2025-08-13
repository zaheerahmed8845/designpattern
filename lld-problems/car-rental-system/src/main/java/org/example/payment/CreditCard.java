package org.example.payment;

import org.example.entity.Address;
import org.example.enums.PaymentStatus;

public class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private int code;
    private Address billingAddress;

    public CreditCard(double amount, String nameOnCard, String cardNumber, int code, Address billingAddress) {
        super(amount);
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.code = code;
        this.billingAddress = billingAddress;
    }

    @Override
    public boolean makePayment() {
        setStatus(PaymentStatus.Completed);
        return true;
    }
}
