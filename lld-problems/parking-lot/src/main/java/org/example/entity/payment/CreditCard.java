package org.example.entity.payment;

import org.example.enums.PaymentStatus;

public class CreditCard extends Payment {
    public boolean initiateTransaction() {
        status = PaymentStatus.COMPLETED;
        return true;
    }
}
