package org.example.payment;

import org.example.enums.PaymentStatus;

public class Cash extends Payment {
    public Cash(double amount) {
        super(amount);
    }

    @Override
    public boolean makePayment() {
        setStatus(PaymentStatus.Completed);
        return true;
    }
}
