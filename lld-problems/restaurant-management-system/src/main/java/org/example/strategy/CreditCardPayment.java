package org.example.strategy;

import org.example.entity.Bill;

public class CreditCardPayment implements PaymentStrategy {
    private final String nameOnCard;
    private final String zipcode;

    public CreditCardPayment(String nameOnCard, String zipcode) {
        this.nameOnCard = nameOnCard;
        this.zipcode = zipcode;
    }

    @Override
    public boolean charge(Bill bill) {
        // integrate with real PSP here
        return true;
    }
}