package org.example.payment;

import org.example.enums.PaymentStatus;

public class Cash extends Payment {
    @Override
    public PaymentStatus makePayment() {
        this.status = PaymentStatus.Confirmed;
        return status;
    }
}
