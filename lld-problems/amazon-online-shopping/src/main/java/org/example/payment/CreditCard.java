package org.example.payment;

import org.example.entity.Address;
import org.example.enums.PaymentStatus;

public class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private String code;
    private Address billingAddress;

    @Override
    public PaymentStatus makePayment() {
        this.status = PaymentStatus.Confirmed; // stub gateway
        return status;
    }
}
